package fr.polytech.kernel.util.addon;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.Track;
import fr.polytech.kernel.structure.musicalelements.Note;
import fr.polytech.kernel.structure.musicalelements.Rest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PartitionGenerator {

    public void createPartitionFromClip(Clip clip, String fileName){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".tex"))) {
            writer.write("\\documentclass{article}\n");
            writer.write("\\usepackage{musixtex}\n");
            writer.write("\\begin{document}\n");
            writer.write("\\begin{music}");
            writer.newLine();
            // Music starts here


            writer.write("\\end{music}\n");
            writer.write("\\end{document}");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String createPartitionFromClip(Clip clip) {
        StringBuilder latexContent = new StringBuilder();

        // Start the music score
        latexContent.append("\\begin{music}\n");

        for (Bar bar : clip.getBars()) {
            latexContent.append(processBar(bar));
        }

        // End the music score
        latexContent.append("\\end{music}\n");

        return latexContent.toString();
    }

    private String processBar(Bar bar) {
        StringBuilder barContent = new StringBuilder();
        barContent.append("\\startBar\n");  // LaTeX command to start a bar

        for (Track track : bar.getTracks()) {
            barContent.append(processTrack(track));
        }

        barContent.append("\\endBar\n");  // LaTeX command to end a bar
        return barContent.toString();
    }

    private String processTrack(Track track) {
        StringBuilder trackContent = new StringBuilder();

        for (MusicalElement element : track.getMusicalElements()) {
            if (element instanceof Note) {
                trackContent.append(processNote((Note) element));
            } else if (element instanceof Rest) {
                trackContent.append(processRest((Rest) element));
            }
            // Add more cases for different types of musical elements
        }

        return trackContent.toString();
    }

    private String processNote(Note note) {
        return "";
        //return String.format("\\note{%s}{%s} ", note.getPitch(), note.getLength().toLatex());
        // toLatex() is a hypothetical method to convert NoteLength to a LaTeX compatible string
    }

    private String processRest(Rest rest) {
        //return String.format("\\rest{%s} ", rest.getLength().toLatex());
        return "";
    }


}
