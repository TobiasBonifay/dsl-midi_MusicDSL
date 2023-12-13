// Generated from C:/Users/Tobias Bonifay/dsl-midi/antlr/src/main/java/fr/polytech/grammar/MusicDSL.g4 by ANTLR 4.13.1
package fr.polytech.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MusicDSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MusicDSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#musicComposition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMusicComposition(MusicDSLParser.MusicCompositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#globalSettings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalSettings(MusicDSLParser.GlobalSettingsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(MusicDSLParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#bpm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBpm(MusicDSLParser.BpmContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#volume}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVolume(MusicDSLParser.VolumeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#velocity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocity(MusicDSLParser.VelocityContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#instrumentsSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrumentsSection(MusicDSLParser.InstrumentsSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#instrumentDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrumentDefinition(MusicDSLParser.InstrumentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#clipSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClipSection(MusicDSLParser.ClipSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#clip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClip(MusicDSLParser.ClipContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#barSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarSequence(MusicDSLParser.BarSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#barContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarContent(MusicDSLParser.BarContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#tempoChange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTempoChange(MusicDSLParser.TempoChangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#volumeSetting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVolumeSetting(MusicDSLParser.VolumeSettingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#velocitySetting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocitySetting(MusicDSLParser.VelocitySettingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#trackSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrackSequence(MusicDSLParser.TrackSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#track}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrack(MusicDSLParser.TrackContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#trackContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrackContent(MusicDSLParser.TrackContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#noteSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteSequence(MusicDSLParser.NoteSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(MusicDSLParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#duration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDuration(MusicDSLParser.DurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#percussionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercussionElement(MusicDSLParser.PercussionElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#mainSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainSection(MusicDSLParser.MainSectionContext ctx);
}