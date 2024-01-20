package fr.polytech.kernel.util.addon;

import fr.polytech.kernel.App;
import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.structure.musicalelements.Rest;
import fr.polytech.kernel.structure.tracks.DrumTrack;
import fr.polytech.kernel.structure.tracks.MidiTrack;
import fr.polytech.kernel.util.addon.models.BarDTO;
import fr.polytech.kernel.util.addon.models.MusicData;
import fr.polytech.kernel.util.addon.models.NoteDTO;
import fr.polytech.kernel.util.addon.models.TrackDTO;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClipConvertor {

    public String convertClipToJSON(Clip clip, App app) {
        MusicData musicData = new MusicData();

        for (Bar bar : clip.getBars()){
            BarDTO barDTO = new BarDTO(bar.getName());
            barDTO.setTimeSignature(bar.getTimeSignature());
            for (MidiTrack track : bar.getTracks()) {
                if (track instanceof DrumTrack) {
                    continue;
                }
                TrackDTO trackDTO = new TrackDTO();
                trackDTO.setTrackName(track.getName());
                for (MusicalElement note : track.getMusicalElements()) {
                    NoteDTO noteDTO = new NoteDTO();
                    if (note instanceof Rest) { // Silence managing
                        noteDTO.setPitch("r");
                        noteDTO.setDuration(String.valueOf(((Rest) note).getDuration()));
                        noteDTO.setOctave("4");
                        trackDTO.getNotes().add(noteDTO);
                        continue;
                    }
                    if (!(note instanceof Note)) {
                        continue;
                    }
                    Note n = (Note) note;
                    String pitch = n.pitch();
                    noteDTO.setPitch(pitch.substring(0,1).toLowerCase()); // From C4 to c
                    noteDTO.setDuration(String.valueOf(n.noteLength()));
                    noteDTO.setOctave(String.valueOf(pitch.charAt(pitch.length()-1)));
                    trackDTO.getNotes().add(noteDTO);
                }
                barDTO.getTracks().add(trackDTO);
            }
            if (barDTO.getTracks().size() > 0) {
                musicData.getBars().add(barDTO);
            }
        }

        musicData.setTimeSignatureGlobal(app.getGlobalTimeSignature().toString());

        // Serialize to JSON using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            //System.out.println(json);
            return objectMapper.writeValueAsString(musicData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void writeMusicDataJSON(String jsonString){
        try {
            String relativePath = "musicDataAddon.json";
            Path path = Paths.get(relativePath);

            // Écrivez le JSON dans un fichier
            Files.write(path, jsonString.getBytes());

            System.out.println("JSON sauvegardé avec succès dans le fichier : " + relativePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
