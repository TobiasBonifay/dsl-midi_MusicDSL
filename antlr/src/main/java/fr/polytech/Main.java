package fr.polytech;

import fr.polytech.grammar.MusicDSLLexer;
import fr.polytech.grammar.MusicDSLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * The program starting point. Should be run with the path to a MusicDSL file as argument.
 */
public class Main {
    /**
     * Read a MusicDSL file and print the parse tree.
     *
     * @param args the path to the MusicDSL file
     * @throws IOException if the file cannot be read
     */
    public static void main(String[] args) throws IOException {
        String inputFile = args[0];
        CharStream input = CharStreams.fromPath(Paths.get(inputFile));
        MusicDSLLexer lexer = new MusicDSLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MusicDSLParser parser = new MusicDSLParser(tokens);
        ParseTree tree = parser.musicComposition();
        System.out.println(tree.toStringTree(parser));
    }
}
