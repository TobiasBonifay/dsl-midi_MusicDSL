// Generated from C:/Users/Tobias Bonifay/dsl-midi/antlr/src/main/java/fr/polytech/grammar/MusicDSL.g4 by ANTLR 4.13.1
package fr.polytech.grammar;
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
	 * Enter a parse tree produced by {@link MusicDSLParser#volume}.
	 * @param ctx the parse tree
	 */
	void enterVolume(MusicDSLParser.VolumeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#volume}.
	 * @param ctx the parse tree
	 */
	void exitVolume(MusicDSLParser.VolumeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#velocity}.
	 * @param ctx the parse tree
	 */
	void enterVelocity(MusicDSLParser.VelocityContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#velocity}.
	 * @param ctx the parse tree
	 */
	void exitVelocity(MusicDSLParser.VelocityContext ctx);
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
	 * Enter a parse tree produced by {@link MusicDSLParser#velocitySetting}.
	 * @param ctx the parse tree
	 */
	void enterVelocitySetting(MusicDSLParser.VelocitySettingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#velocitySetting}.
	 * @param ctx the parse tree
	 */
	void exitVelocitySetting(MusicDSLParser.VelocitySettingContext ctx);
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
	 * Enter a parse tree produced by {@link MusicDSLParser#duration}.
	 * @param ctx the parse tree
	 */
	void enterDuration(MusicDSLParser.DurationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#duration}.
	 * @param ctx the parse tree
	 */
	void exitDuration(MusicDSLParser.DurationContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link MusicDSLParser#mainSection}.
	 * @param ctx the parse tree
	 */
	void enterMainSection(MusicDSLParser.MainSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicDSLParser#mainSection}.
	 * @param ctx the parse tree
	 */
	void exitMainSection(MusicDSLParser.MainSectionContext ctx);
}