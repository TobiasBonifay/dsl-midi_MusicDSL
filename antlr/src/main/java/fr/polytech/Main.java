package fr.polytech;

import fr.polytech.kernel.exceptions.MidiGenerationException;
import fr.polytech.kernel.util.addon.ClipConvertor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * The program's entry point for converting MusicDSL files to MIDI format.
 */
public class Main {

    private static boolean generateJSON = false;

    public static void main(String[] args) {
        try {
            if (args.length == 0 || args.length > 2) {
                System.err.println("Usage: java Main <path_to_MusicDSL_file>");
                return;
            }
            if (args.length == 2 && args[1].equals("--generateJSON")) {
                generateJSON = true;
            }
            processMusicFile(args[0]);
        } catch (IOException | MidiGenerationException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (InvalidMidiDataException e) {
            System.err.println("Error processing MIDI data: " + e.getMessage());
        }
    }

    /**
     * Processes a MusicDSL file.
     *
     * @param filePath The path to the file.
     * @throws IOException              When an I/O error occurs.
     * @throws InvalidMidiDataException When the MIDI data is invalid.
     */
    private static void processMusicFile(String filePath) throws IOException, InvalidMidiDataException, MidiGenerationException {
        final CharStream input = CharStreams.fromPath(Paths.get(filePath));
        final MusicDSLLexer lexer = new MusicDSLLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final MusicDSLParser parser = new MusicDSLParser(tokens);
        final ParseTree tree = parser.musicComposition();

        // System.out.println(tree.toStringTree(parser));
        String[] path = filePath.split("\\\\");
        if (path.length == 1) {
            path = filePath.split("/");
        }
        String fileName = path[path.length-1].split("\\.")[0];
        generateMIDI(tree, fileName);
    }

    /**
     * Generates a MIDI file from a parse tree.
     *
     * @param tree The parse tree.
     * @throws InvalidMidiDataException When the MIDI data is invalid.
     * @throws IOException              When an I/O error occurs.
     */
    private static void generateMIDI(ParseTree tree, String fileName) throws IOException, MidiGenerationException, InvalidMidiDataException {
        MidiGeneratorWithKernel visitor = new MidiGeneratorWithKernel();
        visitor.visit(tree);
        visitor.writeMidiFile(fileName);
        if (generateJSON) { // MusicDATA json generation for Addon
            ClipConvertor clipConvertor = new ClipConvertor();
            String json = clipConvertor.convertClipToJSON(visitor.getCurrentClip(), visitor.getApp());
            clipConvertor.writeMusicDataJSON(json);
        }
        System.out.println("MIDI file generated");
    }
}
