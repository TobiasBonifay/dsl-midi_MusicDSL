// Generated from /Users/igormelnyk/Documents/SI5/DSL/dsl-midi_MusicDSL/antlr/src/main/java/fr/polytech/MusicDSL.g4 by ANTLR 4.13.1
package fr.polytech;
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
	 * Visit a parse tree produced by {@link MusicDSLParser#tempoChange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTempoChange(MusicDSLParser.TempoChangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#timeshift}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeshift(MusicDSLParser.TimeshiftContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#velocityrandomization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVelocityrandomization(MusicDSLParser.VelocityrandomizationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#resolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResolution(MusicDSLParser.ResolutionContext ctx);
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
	 * Visit a parse tree produced by {@link MusicDSLParser#defaultDynamic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultDynamic(MusicDSLParser.DefaultDynamicContext ctx);
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
	 * Visit a parse tree produced by {@link MusicDSLParser#emptyBarContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyBarContent(MusicDSLParser.EmptyBarContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#volumeSetting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVolumeSetting(MusicDSLParser.VolumeSettingContext ctx);
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
	 * Visit a parse tree produced by {@link MusicDSLParser#noteDynamic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteDynamic(MusicDSLParser.NoteDynamicContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#noteDuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteDuration(MusicDSLParser.NoteDurationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(MusicDSLParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#chord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChord(MusicDSLParser.ChordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#silence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSilence(MusicDSLParser.SilenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#timelineSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimelineSection(MusicDSLParser.TimelineSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#timelineSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimelineSequence(MusicDSLParser.TimelineSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#timelineClip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimelineClip(MusicDSLParser.TimelineClipContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#percussionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercussionSequence(MusicDSLParser.PercussionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicDSLParser#percussionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercussionElement(MusicDSLParser.PercussionElementContext ctx);
}