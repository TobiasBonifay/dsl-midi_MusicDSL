package fr.polytech.kernel.util.addon;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;
import fr.polytech.kernel.structure.MusicalElement;
import fr.polytech.kernel.structure.Track;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class PartitionGenerator {

    private static final Logger LOGGER = Logger.getLogger(PartitionGenerator.class.getName());
    private static final String LATEX_HEADER = """
            \\documentclass{article}
            \\usepackage{musixtex}
            \\begin{document}
            \\begin{music}
            """;
    private static final String LATEX_FOOTER = "\\end{music}\n" + "\\end{document}";

    public void createPartitionFromClip(Clip clip, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".tex"))) {
            writer.write(LATEX_HEADER);
            for (Bar bar : clip.getBars()) {
                // for each bar generate the right latex notation
                writer.write("\\startpiece\n");
                for (Track track : bar.getTracks()) {
                    // for each track generate the right latex notation with the name
                    int instrumentNumber = track.getInstrument().midiInstrument().getInstrumentNumber();
                    LOGGER.info("newInstrument " + instrumentNumber);
                    writer.write("\\instrumentnumber{" + instrumentNumber + "}\n");
                    for (MusicalElement element : track.getMusicalElements()) {
                        String musicalElementLatex = element.toLatex();
                        LOGGER.info("musicalElementLatex " + musicalElementLatex);
                        writer.write(musicalElementLatex);
                    }
                }
                writer.write("\\endpiece\n");
            }
            writer.write(LATEX_FOOTER);
        } catch (IOException e) {
            LOGGER.severe("Error writing to file");
            LOGGER.severe(e.getMessage());
        }
    }
}
