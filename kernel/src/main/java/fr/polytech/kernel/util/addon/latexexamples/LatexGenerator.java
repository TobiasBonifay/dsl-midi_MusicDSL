package fr.polytech.kernel.util.addon.latexexamples;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;

public class LatexGenerator {
    public String generateLatex(Clip clip) {
        StringBuilder latexDocument = new StringBuilder();
        latexDocument.append("\\begin{music}\n"); // Assuming a LaTeX music environment
        for (Bar bar : clip.getBars()) {
            //latexDocument.append(bar.toLatex()).append("\n");
        }
        latexDocument.append("\\end{music}");
        return latexDocument.toString();
    }
}
