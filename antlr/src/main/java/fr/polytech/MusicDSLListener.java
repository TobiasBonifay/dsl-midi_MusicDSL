// Generated from /Users/igormelnyk/Documents/SI5/DSL/dsl-midi_MusicDSL/antlr/src/main/java/fr/polytech/MusicDSL.g4 by ANTLR 4.13.1
package fr.polytech;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusicDSLParser}.
 */
public interface MusicDSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#musicComposition}.
	 * @param ctx the parse tree
	 */
	void enterMusicComposition(MusicDSLParser.MusicCompositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#musicComposition}.
	 * @param ctx the parse tree
	 */
	void exitMusicComposition(MusicDSLParser.MusicCompositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#globalSettings}.
	 * @param ctx the parse tree
	 */
	void enterGlobalSettings(MusicDSLParser.GlobalSettingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#globalSettings}.
	 * @param ctx the parse tree
	 */
	void exitGlobalSettings(MusicDSLParser.GlobalSettingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#signature}.
	 * @param ctx the parse tree
	 */
	void enterSignature(MusicDSLParser.SignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#signature}.
	 * @param ctx the parse tree
	 */
	void exitSignature(MusicDSLParser.SignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#bpm}.
	 * @param ctx the parse tree
	 */
	void enterBpm(MusicDSLParser.BpmContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#bpm}.
	 * @param ctx the parse tree
	 */
	void exitBpm(MusicDSLParser.BpmContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#tempoChange}.
	 * @param ctx the parse tree
	 */
	void enterTempoChange(MusicDSLParser.TempoChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#tempoChange}.
	 * @param ctx the parse tree
	 */
	void exitTempoChange(MusicDSLParser.TempoChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#timeshift}.
	 * @param ctx the parse tree
	 */
	void enterTimeshift(MusicDSLParser.TimeshiftContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#timeshift}.
	 * @param ctx the parse tree
	 */
	void exitTimeshift(MusicDSLParser.TimeshiftContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#velocityrandomization}.
	 * @param ctx the parse tree
	 */
	void enterVelocityrandomization(MusicDSLParser.VelocityrandomizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#velocityrandomization}.
	 * @param ctx the parse tree
	 */
	void exitVelocityrandomization(MusicDSLParser.VelocityrandomizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#resolution}.
	 * @param ctx the parse tree
	 */
	void enterResolution(MusicDSLParser.ResolutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#resolution}.
	 * @param ctx the parse tree
	 */
	void exitResolution(MusicDSLParser.ResolutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#instrumentsSection}.
	 * @param ctx the parse tree
	 */
	void enterInstrumentsSection(MusicDSLParser.InstrumentsSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#instrumentsSection}.
	 * @param ctx the parse tree
	 */
	void exitInstrumentsSection(MusicDSLParser.InstrumentsSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#instrumentDefinition}.
	 * @param ctx the parse tree
	 */
	void enterInstrumentDefinition(MusicDSLParser.InstrumentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#instrumentDefinition}.
	 * @param ctx the parse tree
	 */
	void exitInstrumentDefinition(MusicDSLParser.InstrumentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#clipSection}.
	 * @param ctx the parse tree
	 */
	void enterClipSection(MusicDSLParser.ClipSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#clipSection}.
	 * @param ctx the parse tree
	 */
	void exitClipSection(MusicDSLParser.ClipSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#clip}.
	 * @param ctx the parse tree
	 */
	void enterClip(MusicDSLParser.ClipContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#clip}.
	 * @param ctx the parse tree
	 */
	void exitClip(MusicDSLParser.ClipContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#defaultDynamic}.
	 * @param ctx the parse tree
	 */
	void enterDefaultDynamic(MusicDSLParser.DefaultDynamicContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#defaultDynamic}.
	 * @param ctx the parse tree
	 */
	void exitDefaultDynamic(MusicDSLParser.DefaultDynamicContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#barSequence}.
	 * @param ctx the parse tree
	 */
	void enterBarSequence(MusicDSLParser.BarSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#barSequence}.
	 * @param ctx the parse tree
	 */
	void exitBarSequence(MusicDSLParser.BarSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#barContent}.
	 * @param ctx the parse tree
	 */
	void enterBarContent(MusicDSLParser.BarContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#barContent}.
	 * @param ctx the parse tree
	 */
	void exitBarContent(MusicDSLParser.BarContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#emptyBarContent}.
	 * @param ctx the parse tree
	 */
	void enterEmptyBarContent(MusicDSLParser.EmptyBarContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#emptyBarContent}.
	 * @param ctx the parse tree
	 */
	void exitEmptyBarContent(MusicDSLParser.EmptyBarContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#volumeSetting}.
	 * @param ctx the parse tree
	 */
	void enterVolumeSetting(MusicDSLParser.VolumeSettingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#volumeSetting}.
	 * @param ctx the parse tree
	 */
	void exitVolumeSetting(MusicDSLParser.VolumeSettingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#trackSequence}.
	 * @param ctx the parse tree
	 */
	void enterTrackSequence(MusicDSLParser.TrackSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#trackSequence}.
	 * @param ctx the parse tree
	 */
	void exitTrackSequence(MusicDSLParser.TrackSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#track}.
	 * @param ctx the parse tree
	 */
	void enterTrack(MusicDSLParser.TrackContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#track}.
	 * @param ctx the parse tree
	 */
	void exitTrack(MusicDSLParser.TrackContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#trackContent}.
	 * @param ctx the parse tree
	 */
	void enterTrackContent(MusicDSLParser.TrackContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#trackContent}.
	 * @param ctx the parse tree
	 */
	void exitTrackContent(MusicDSLParser.TrackContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#noteSequence}.
	 * @param ctx the parse tree
	 */
	void enterNoteSequence(MusicDSLParser.NoteSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#noteSequence}.
	 * @param ctx the parse tree
	 */
	void exitNoteSequence(MusicDSLParser.NoteSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#noteDynamic}.
	 * @param ctx the parse tree
	 */
	void enterNoteDynamic(MusicDSLParser.NoteDynamicContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#noteDynamic}.
	 * @param ctx the parse tree
	 */
	void exitNoteDynamic(MusicDSLParser.NoteDynamicContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#noteDuration}.
	 * @param ctx the parse tree
	 */
	void enterNoteDuration(MusicDSLParser.NoteDurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#noteDuration}.
	 * @param ctx the parse tree
	 */
	void exitNoteDuration(MusicDSLParser.NoteDurationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(MusicDSLParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(MusicDSLParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#chord}.
	 * @param ctx the parse tree
	 */
	void enterChord(MusicDSLParser.ChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#chord}.
	 * @param ctx the parse tree
	 */
	void exitChord(MusicDSLParser.ChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#silence}.
	 * @param ctx the parse tree
	 */
	void enterSilence(MusicDSLParser.SilenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#silence}.
	 * @param ctx the parse tree
	 */
	void exitSilence(MusicDSLParser.SilenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#timelineSection}.
	 * @param ctx the parse tree
	 */
	void enterTimelineSection(MusicDSLParser.TimelineSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#timelineSection}.
	 * @param ctx the parse tree
	 */
	void exitTimelineSection(MusicDSLParser.TimelineSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#timelineSequence}.
	 * @param ctx the parse tree
	 */
	void enterTimelineSequence(MusicDSLParser.TimelineSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#timelineSequence}.
	 * @param ctx the parse tree
	 */
	void exitTimelineSequence(MusicDSLParser.TimelineSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#timelineClip}.
	 * @param ctx the parse tree
	 */
	void enterTimelineClip(MusicDSLParser.TimelineClipContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#timelineClip}.
	 * @param ctx the parse tree
	 */
	void exitTimelineClip(MusicDSLParser.TimelineClipContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#percussionSequence}.
	 * @param ctx the parse tree
	 */
	void enterPercussionSequence(MusicDSLParser.PercussionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#percussionSequence}.
	 * @param ctx the parse tree
	 */
	void exitPercussionSequence(MusicDSLParser.PercussionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#percussionElement}.
	 * @param ctx the parse tree
	 */
	void enterPercussionElement(MusicDSLParser.PercussionElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#percussionElement}.
	 * @param ctx the parse tree
	 */
	void exitPercussionElement(MusicDSLParser.PercussionElementContext ctx);
}