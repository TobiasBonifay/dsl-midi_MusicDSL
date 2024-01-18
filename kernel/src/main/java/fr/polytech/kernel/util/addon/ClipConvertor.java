package fr.polytech.kernel.util.addon;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.structure.tracks.MidiTrack;
import fr.polytech.kernel.util.addon.models.BarDTO;
import fr.polytech.kernel.util.addon.models.MusicData;
import fr.polytech.kernel.util.addon.models.NoteDTO;
import fr.polytech.kernel.util.addon.models.TrackDTO;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ClipConvertor {

    public void convertClipToJSON(Clip clip) {
        MusicData musicData = new MusicData();

        for (Bar bar : clip.getBars()){
            BarDTO barDTO = new BarDTO(bar.getName());
            barDTO.setTimeSignature(bar.getTimeSignature());
            for (MidiTrack track : bar.getTracks()) {
                TrackDTO trackDTO = new TrackDTO();
                trackDTO.setTrackName(track.getName());
                for (MusicalElement note : track.getMusicalElements()) {
                    NoteDTO noteDTO = new NoteDTO();
                    Note n = (Note) note;
                    String pitch = n.pitch();
                    noteDTO.setPitch(pitch.substring(0,1).toLowerCase()); // From C4 to c
                    noteDTO.setDuration(n.noteLength().toString());
                    noteDTO.setOctave(String.valueOf(pitch.charAt(pitch.length()-1)));
                    trackDTO.getNotes().add(noteDTO);
                }
                barDTO.getTracks().add(trackDTO);
            }
            musicData.getBars().add(barDTO);
        }

        // Serialize to JSON using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            String json = objectMapper.writeValueAsString(musicData);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
