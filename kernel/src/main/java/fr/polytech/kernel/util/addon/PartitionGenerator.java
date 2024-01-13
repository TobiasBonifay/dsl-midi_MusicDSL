package fr.polytech.kernel.util.addon;

import fr.polytech.kernel.structure.Clip;

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

}
