package fr.polytech.kernel.util.addon.latexexamples;

import fr.polytech.kernel.structure.Bar;
import fr.polytech.kernel.structure.Clip;

public class LatexGenerator {
    public String generateLatex(Clip clip) {
        StringBuilder latexContent = new StringBuilder("\\begin{music}\n");

        for (Bar bar : clip.getBars()) {
            latexContent.append(bar.toLatex());
        }

        latexContent.append("\\end{music}");
        return latexContent.toString();
    }
}
