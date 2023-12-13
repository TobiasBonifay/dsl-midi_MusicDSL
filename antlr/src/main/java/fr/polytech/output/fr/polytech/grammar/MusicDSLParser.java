// Generated from C:/Users/Tobias Bonifay/dsl-midi/antlr/src/main/java/fr/polytech/grammar/MusicDSL.g4 by ANTLR 4.13.1
package fr.polytech.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MusicDSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		FRACTION=18, SIGNED_INT=19, INT=20, VELOCITY_SYMBOL=21, INSTRUMENT=22, 
		NOTE=23, PERCUSSION=24, CLIP_NAME=25, MAIN_SEQUENCE=26, WS=27, LINE_COMMENT=28;
	public static final int
		RULE_musicComposition = 0, RULE_globalSettings = 1, RULE_signature = 2, 
		RULE_bpm = 3, RULE_volume = 4, RULE_velocity = 5, RULE_instrumentsSection = 6, 
		RULE_instrumentDefinition = 7, RULE_clipSection = 8, RULE_clip = 9, RULE_barSequence = 10, 
		RULE_barContent = 11, RULE_tempoChange = 12, RULE_volumeSetting = 13, 
		RULE_velocitySetting = 14, RULE_trackSequence = 15, RULE_track = 16, RULE_trackContent = 17, 
		RULE_noteSequence = 18, RULE_note = 19, RULE_duration = 20, RULE_percussionElement = 21, 
		RULE_mainSection = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"musicComposition", "globalSettings", "signature", "bpm", "volume", "velocity", 
			"instrumentsSection", "instrumentDefinition", "clipSection", "clip", 
			"barSequence", "barContent", "tempoChange", "volumeSetting", "velocitySetting", 
			"trackSequence", "track", "trackContent", "noteSequence", "note", "duration", 
			"percussionElement", "mainSection"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'signature'", "'bpm'", "'volume'", "'velocity'", "'Instruments:'", 
			"'clip'", "':'", "'bar'", "'['", "']'", "'LINEAR|'", "'tempo'", "'track'", 
			"','", "'('", "')'", "'|'", null, null, null, null, null, null, null, 
			null, "'CHORUS x2 COUPLET-A CHORUS'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "FRACTION", "SIGNED_INT", "INT", 
			"VELOCITY_SYMBOL", "INSTRUMENT", "NOTE", "PERCUSSION", "CLIP_NAME", "MAIN_SEQUENCE", 
			"WS", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MusicDSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MusicDSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MusicCompositionContext extends ParserRuleContext {
		public GlobalSettingsContext globalSettings() {
			return getRuleContext(GlobalSettingsContext.class,0);
		}
		public InstrumentsSectionContext instrumentsSection() {
			return getRuleContext(InstrumentsSectionContext.class,0);
		}
		public ClipSectionContext clipSection() {
			return getRuleContext(ClipSectionContext.class,0);
		}
		public MainSectionContext mainSection() {
			return getRuleContext(MainSectionContext.class,0);
		}
		public MusicCompositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_musicComposition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterMusicComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitMusicComposition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitMusicComposition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MusicCompositionContext musicComposition() throws RecognitionException {
		MusicCompositionContext _localctx = new MusicCompositionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_musicComposition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			globalSettings();
			setState(47);
			instrumentsSection();
			setState(48);
			clipSection();
			setState(49);
			mainSection();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalSettingsContext extends ParserRuleContext {
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public BpmContext bpm() {
			return getRuleContext(BpmContext.class,0);
		}
		public VolumeContext volume() {
			return getRuleContext(VolumeContext.class,0);
		}
		public VelocityContext velocity() {
			return getRuleContext(VelocityContext.class,0);
		}
		public GlobalSettingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalSettings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterGlobalSettings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitGlobalSettings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitGlobalSettings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalSettingsContext globalSettings() throws RecognitionException {
		GlobalSettingsContext _localctx = new GlobalSettingsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalSettings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(51);
				signature();
				}
			}

			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(54);
				bpm();
				}
			}

			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(57);
				volume();
				}
			}

			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(60);
				velocity();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SignatureContext extends ParserRuleContext {
		public TerminalNode FRACTION() { return getToken(MusicDSLParser.FRACTION, 0); }
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_signature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__0);
			setState(64);
			match(FRACTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BpmContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public BpmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bpm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterBpm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitBpm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitBpm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BpmContext bpm() throws RecognitionException {
		BpmContext _localctx = new BpmContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bpm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__1);
			setState(67);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VolumeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public VolumeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_volume; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterVolume(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitVolume(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitVolume(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VolumeContext volume() throws RecognitionException {
		VolumeContext _localctx = new VolumeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_volume);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__2);
			setState(70);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VelocityContext extends ParserRuleContext {
		public TerminalNode VELOCITY_SYMBOL() { return getToken(MusicDSLParser.VELOCITY_SYMBOL, 0); }
		public VelocityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterVelocity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitVelocity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitVelocity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VelocityContext velocity() throws RecognitionException {
		VelocityContext _localctx = new VelocityContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_velocity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__3);
			setState(73);
			match(VELOCITY_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstrumentsSectionContext extends ParserRuleContext {
		public List<InstrumentDefinitionContext> instrumentDefinition() {
			return getRuleContexts(InstrumentDefinitionContext.class);
		}
		public InstrumentDefinitionContext instrumentDefinition(int i) {
			return getRuleContext(InstrumentDefinitionContext.class,i);
		}
		public InstrumentsSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrumentsSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterInstrumentsSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitInstrumentsSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitInstrumentsSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrumentsSectionContext instrumentsSection() throws RecognitionException {
		InstrumentsSectionContext _localctx = new InstrumentsSectionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instrumentsSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__4);
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				instrumentDefinition();
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INSTRUMENT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstrumentDefinitionContext extends ParserRuleContext {
		public TerminalNode INSTRUMENT() { return getToken(MusicDSLParser.INSTRUMENT, 0); }
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public InstrumentDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrumentDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterInstrumentDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitInstrumentDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitInstrumentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrumentDefinitionContext instrumentDefinition() throws RecognitionException {
		InstrumentDefinitionContext _localctx = new InstrumentDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instrumentDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(INSTRUMENT);
			setState(82);
			match(T__2);
			setState(83);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClipSectionContext extends ParserRuleContext {
		public List<ClipContext> clip() {
			return getRuleContexts(ClipContext.class);
		}
		public ClipContext clip(int i) {
			return getRuleContext(ClipContext.class,i);
		}
		public ClipSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clipSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterClipSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitClipSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitClipSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClipSectionContext clipSection() throws RecognitionException {
		ClipSectionContext _localctx = new ClipSectionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_clipSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__5);
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(86);
				clip();
				}
				}
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLIP_NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClipContext extends ParserRuleContext {
		public TerminalNode CLIP_NAME() { return getToken(MusicDSLParser.CLIP_NAME, 0); }
		public BarSequenceContext barSequence() {
			return getRuleContext(BarSequenceContext.class,0);
		}
		public ClipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterClip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitClip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitClip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClipContext clip() throws RecognitionException {
		ClipContext _localctx = new ClipContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_clip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(CLIP_NAME);
			setState(92);
			match(T__6);
			setState(93);
			barSequence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BarSequenceContext extends ParserRuleContext {
		public BarContentContext barContent() {
			return getRuleContext(BarContentContext.class,0);
		}
		public BarSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterBarSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitBarSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitBarSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarSequenceContext barSequence() throws RecognitionException {
		BarSequenceContext _localctx = new BarSequenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_barSequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__7);
			setState(96);
			match(T__8);
			setState(97);
			barContent();
			setState(98);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BarContentContext extends ParserRuleContext {
		public TrackSequenceContext trackSequence() {
			return getRuleContext(TrackSequenceContext.class,0);
		}
		public TempoChangeContext tempoChange() {
			return getRuleContext(TempoChangeContext.class,0);
		}
		public VolumeSettingContext volumeSetting() {
			return getRuleContext(VolumeSettingContext.class,0);
		}
		public VelocitySettingContext velocitySetting() {
			return getRuleContext(VelocitySettingContext.class,0);
		}
		public BarContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterBarContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitBarContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitBarContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarContentContext barContent() throws RecognitionException {
		BarContentContext _localctx = new BarContentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_barContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(100);
				tempoChange();
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(103);
				volumeSetting();
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VELOCITY_SYMBOL) {
				{
				setState(106);
				velocitySetting();
				}
			}

			setState(109);
			trackSequence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TempoChangeContext extends ParserRuleContext {
		public TerminalNode SIGNED_INT() { return getToken(MusicDSLParser.SIGNED_INT, 0); }
		public TempoChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempoChange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterTempoChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitTempoChange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitTempoChange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TempoChangeContext tempoChange() throws RecognitionException {
		TempoChangeContext _localctx = new TempoChangeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tempoChange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__10);
			setState(112);
			match(T__11);
			setState(113);
			match(SIGNED_INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VolumeSettingContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public VolumeSettingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_volumeSetting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterVolumeSetting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitVolumeSetting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitVolumeSetting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VolumeSettingContext volumeSetting() throws RecognitionException {
		VolumeSettingContext _localctx = new VolumeSettingContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_volumeSetting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__2);
			setState(116);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VelocitySettingContext extends ParserRuleContext {
		public TerminalNode VELOCITY_SYMBOL() { return getToken(MusicDSLParser.VELOCITY_SYMBOL, 0); }
		public VelocitySettingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocitySetting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterVelocitySetting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitVelocitySetting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitVelocitySetting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VelocitySettingContext velocitySetting() throws RecognitionException {
		VelocitySettingContext _localctx = new VelocitySettingContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_velocitySetting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(VELOCITY_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TrackSequenceContext extends ParserRuleContext {
		public List<TrackContext> track() {
			return getRuleContexts(TrackContext.class);
		}
		public TrackContext track(int i) {
			return getRuleContext(TrackContext.class,i);
		}
		public TrackSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trackSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterTrackSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitTrackSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitTrackSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrackSequenceContext trackSequence() throws RecognitionException {
		TrackSequenceContext _localctx = new TrackSequenceContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_trackSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				track();
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TrackContext extends ParserRuleContext {
		public TerminalNode INSTRUMENT() { return getToken(MusicDSLParser.INSTRUMENT, 0); }
		public TrackContentContext trackContent() {
			return getRuleContext(TrackContentContext.class,0);
		}
		public TrackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_track; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterTrack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitTrack(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitTrack(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrackContext track() throws RecognitionException {
		TrackContext _localctx = new TrackContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_track);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__12);
			setState(126);
			match(INSTRUMENT);
			setState(127);
			trackContent();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TrackContentContext extends ParserRuleContext {
		public List<NoteSequenceContext> noteSequence() {
			return getRuleContexts(NoteSequenceContext.class);
		}
		public NoteSequenceContext noteSequence(int i) {
			return getRuleContext(NoteSequenceContext.class,i);
		}
		public List<PercussionElementContext> percussionElement() {
			return getRuleContexts(PercussionElementContext.class);
		}
		public PercussionElementContext percussionElement(int i) {
			return getRuleContext(PercussionElementContext.class,i);
		}
		public TrackContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trackContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterTrackContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitTrackContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitTrackContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrackContentContext trackContent() throws RecognitionException {
		TrackContentContext _localctx = new TrackContentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_trackContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(131);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOTE:
					{
					setState(129);
					noteSequence();
					}
					break;
				case PERCUSSION:
					{
					setState(130);
					percussionElement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NOTE || _la==PERCUSSION );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NoteSequenceContext extends ParserRuleContext {
		public List<NoteContext> note() {
			return getRuleContexts(NoteContext.class);
		}
		public NoteContext note(int i) {
			return getRuleContext(NoteContext.class,i);
		}
		public NoteSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterNoteSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitNoteSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitNoteSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteSequenceContext noteSequence() throws RecognitionException {
		NoteSequenceContext _localctx = new NoteSequenceContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_noteSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			note();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(136);
				match(T__13);
				setState(137);
				note();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NoteContext extends ParserRuleContext {
		public TerminalNode NOTE() { return getToken(MusicDSLParser.NOTE, 0); }
		public VelocitySettingContext velocitySetting() {
			return getRuleContext(VelocitySettingContext.class,0);
		}
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(NOTE);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VELOCITY_SYMBOL) {
				{
				setState(144);
				velocitySetting();
				}
			}

			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(147);
				duration();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DurationContext extends ParserRuleContext {
		public TerminalNode FRACTION() { return getToken(MusicDSLParser.FRACTION, 0); }
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_duration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__14);
			setState(151);
			match(FRACTION);
			setState(152);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PercussionElementContext extends ParserRuleContext {
		public TerminalNode PERCUSSION() { return getToken(MusicDSLParser.PERCUSSION, 0); }
		public TerminalNode NOTE() { return getToken(MusicDSLParser.NOTE, 0); }
		public PercussionElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percussionElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterPercussionElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitPercussionElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitPercussionElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PercussionElementContext percussionElement() throws RecognitionException {
		PercussionElementContext _localctx = new PercussionElementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_percussionElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(PERCUSSION);
			setState(155);
			match(T__16);
			setState(156);
			match(NOTE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainSectionContext extends ParserRuleContext {
		public TerminalNode MAIN_SEQUENCE() { return getToken(MusicDSLParser.MAIN_SEQUENCE, 0); }
		public MainSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterMainSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitMainSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitMainSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainSectionContext mainSection() throws RecognitionException {
		MainSectionContext _localctx = new MainSectionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mainSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(MAIN_SEQUENCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u00a1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0003\u00015\b\u0001\u0001\u0001\u0003"+
		"\u00018\b\u0001\u0001\u0001\u0003\u0001;\b\u0001\u0001\u0001\u0003\u0001"+
		">\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0004\u0006N\b\u0006\u000b\u0006"+
		"\f\u0006O\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0004\bX\b\b\u000b\b\f\bY\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0003\u000bf\b\u000b\u0001\u000b"+
		"\u0003\u000bi\b\u000b\u0001\u000b\u0003\u000bl\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0004\u000fz\b\u000f\u000b\u000f\f\u000f{\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0004"+
		"\u0011\u0084\b\u0011\u000b\u0011\f\u0011\u0085\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u008b\b\u0012\n\u0012\f\u0012\u008e\t\u0012\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u0092\b\u0013\u0001\u0013\u0003\u0013\u0095"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0000"+
		"\u0000\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0000\u0098\u0000.\u0001\u0000"+
		"\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u0004?\u0001\u0000\u0000\u0000"+
		"\u0006B\u0001\u0000\u0000\u0000\bE\u0001\u0000\u0000\u0000\nH\u0001\u0000"+
		"\u0000\u0000\fK\u0001\u0000\u0000\u0000\u000eQ\u0001\u0000\u0000\u0000"+
		"\u0010U\u0001\u0000\u0000\u0000\u0012[\u0001\u0000\u0000\u0000\u0014_"+
		"\u0001\u0000\u0000\u0000\u0016e\u0001\u0000\u0000\u0000\u0018o\u0001\u0000"+
		"\u0000\u0000\u001as\u0001\u0000\u0000\u0000\u001cv\u0001\u0000\u0000\u0000"+
		"\u001ey\u0001\u0000\u0000\u0000 }\u0001\u0000\u0000\u0000\"\u0083\u0001"+
		"\u0000\u0000\u0000$\u0087\u0001\u0000\u0000\u0000&\u008f\u0001\u0000\u0000"+
		"\u0000(\u0096\u0001\u0000\u0000\u0000*\u009a\u0001\u0000\u0000\u0000,"+
		"\u009e\u0001\u0000\u0000\u0000./\u0003\u0002\u0001\u0000/0\u0003\f\u0006"+
		"\u000001\u0003\u0010\b\u000012\u0003,\u0016\u00002\u0001\u0001\u0000\u0000"+
		"\u000035\u0003\u0004\u0002\u000043\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u000057\u0001\u0000\u0000\u000068\u0003\u0006\u0003\u000076\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u0000"+
		"9;\u0003\b\u0004\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";=\u0001\u0000\u0000\u0000<>\u0003\n\u0005\u0000=<\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000>\u0003\u0001\u0000\u0000\u0000?@\u0005\u0001"+
		"\u0000\u0000@A\u0005\u0012\u0000\u0000A\u0005\u0001\u0000\u0000\u0000"+
		"BC\u0005\u0002\u0000\u0000CD\u0005\u0014\u0000\u0000D\u0007\u0001\u0000"+
		"\u0000\u0000EF\u0005\u0003\u0000\u0000FG\u0005\u0014\u0000\u0000G\t\u0001"+
		"\u0000\u0000\u0000HI\u0005\u0004\u0000\u0000IJ\u0005\u0015\u0000\u0000"+
		"J\u000b\u0001\u0000\u0000\u0000KM\u0005\u0005\u0000\u0000LN\u0003\u000e"+
		"\u0007\u0000ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\r\u0001\u0000\u0000\u0000"+
		"QR\u0005\u0016\u0000\u0000RS\u0005\u0003\u0000\u0000ST\u0005\u0014\u0000"+
		"\u0000T\u000f\u0001\u0000\u0000\u0000UW\u0005\u0006\u0000\u0000VX\u0003"+
		"\u0012\t\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\u0011\u0001\u0000\u0000"+
		"\u0000[\\\u0005\u0019\u0000\u0000\\]\u0005\u0007\u0000\u0000]^\u0003\u0014"+
		"\n\u0000^\u0013\u0001\u0000\u0000\u0000_`\u0005\b\u0000\u0000`a\u0005"+
		"\t\u0000\u0000ab\u0003\u0016\u000b\u0000bc\u0005\n\u0000\u0000c\u0015"+
		"\u0001\u0000\u0000\u0000df\u0003\u0018\f\u0000ed\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000gi\u0003\u001a\r\u0000"+
		"hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000"+
		"\u0000jl\u0003\u001c\u000e\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0003\u001e\u000f\u0000n\u0017"+
		"\u0001\u0000\u0000\u0000op\u0005\u000b\u0000\u0000pq\u0005\f\u0000\u0000"+
		"qr\u0005\u0013\u0000\u0000r\u0019\u0001\u0000\u0000\u0000st\u0005\u0003"+
		"\u0000\u0000tu\u0005\u0014\u0000\u0000u\u001b\u0001\u0000\u0000\u0000"+
		"vw\u0005\u0015\u0000\u0000w\u001d\u0001\u0000\u0000\u0000xz\u0003 \u0010"+
		"\u0000yx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|\u001f\u0001\u0000\u0000\u0000"+
		"}~\u0005\r\u0000\u0000~\u007f\u0005\u0016\u0000\u0000\u007f\u0080\u0003"+
		"\"\u0011\u0000\u0080!\u0001\u0000\u0000\u0000\u0081\u0084\u0003$\u0012"+
		"\u0000\u0082\u0084\u0003*\u0015\u0000\u0083\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000"+
		"\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086#\u0001\u0000\u0000\u0000\u0087\u008c\u0003&\u0013\u0000\u0088\u0089"+
		"\u0005\u000e\u0000\u0000\u0089\u008b\u0003&\u0013\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d%\u0001\u0000"+
		"\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0091\u0005\u0017"+
		"\u0000\u0000\u0090\u0092\u0003\u001c\u000e\u0000\u0091\u0090\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000"+
		"\u0000\u0000\u0093\u0095\u0003(\u0014\u0000\u0094\u0093\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\'\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005\u000f\u0000\u0000\u0097\u0098\u0005\u0012\u0000\u0000"+
		"\u0098\u0099\u0005\u0010\u0000\u0000\u0099)\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005\u0018\u0000\u0000\u009b\u009c\u0005\u0011\u0000\u0000\u009c"+
		"\u009d\u0005\u0017\u0000\u0000\u009d+\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0005\u001a\u0000\u0000\u009f-\u0001\u0000\u0000\u0000\u000f47:=OYeh"+
		"k{\u0083\u0085\u008c\u0091\u0094";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}