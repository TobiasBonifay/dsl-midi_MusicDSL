// Generated from /Users/igormelnyk/Documents/SI5/DSL/dsl-midi_MusicDSL/antlr/src/main/java/fr/polytech/MusicDSL.g4 by ANTLR 4.13.1
package fr.polytech;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MusicDSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, INT=24, SIGNED_INT=25, 
		FRACTION=26, VELOCITY_SYMBOL=27, INSTRUMENT=28, NOTE=29, LATIN_NOTE=30, 
		CHORD=31, SILENCE=32, PERCUSSION=33, ID=34, WS=35, LINE_COMMENT=36;
	public static final int
		RULE_musicComposition = 0, RULE_globalSettings = 1, RULE_signature = 2, 
		RULE_bpm = 3, RULE_tempoChange = 4, RULE_timeshift = 5, RULE_velocityrandomization = 6, 
		RULE_resolution = 7, RULE_instrumentsSection = 8, RULE_instrumentDefinition = 9, 
		RULE_clipSection = 10, RULE_clip = 11, RULE_defaultDynamic = 12, RULE_barSequence = 13, 
		RULE_barContent = 14, RULE_emptyBarContent = 15, RULE_volumeSetting = 16, 
		RULE_trackSequence = 17, RULE_track = 18, RULE_trackContent = 19, RULE_noteSequence = 20, 
		RULE_noteDynamic = 21, RULE_noteDuration = 22, RULE_note = 23, RULE_chord = 24, 
		RULE_silence = 25, RULE_timelineSection = 26, RULE_timelineSequence = 27, 
		RULE_timelineClip = 28, RULE_percussionSequence = 29, RULE_percussionElement = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"musicComposition", "globalSettings", "signature", "bpm", "tempoChange", 
			"timeshift", "velocityrandomization", "resolution", "instrumentsSection", 
			"instrumentDefinition", "clipSection", "clip", "defaultDynamic", "barSequence", 
			"barContent", "emptyBarContent", "volumeSetting", "trackSequence", "track", 
			"trackContent", "noteSequence", "noteDynamic", "noteDuration", "note", 
			"chord", "silence", "timelineSection", "timelineSequence", "timelineClip", 
			"percussionSequence", "percussionElement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'signature'", "'bpm'", "'tempo'", "'+'", "'-'", "'timeshift'", 
			"'velocityrandomization'", "'resolution'", "'Instruments:'", "'volume'", 
			"'clip'", "':'", "'<-'", "'bar'", "'['", "']'", "'EMPTY'", "'track'", 
			"','", "'('", "')'", "'Timeline:'", "'x'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"INT", "SIGNED_INT", "FRACTION", "VELOCITY_SYMBOL", "INSTRUMENT", "NOTE", 
			"LATIN_NOTE", "CHORD", "SILENCE", "PERCUSSION", "ID", "WS", "LINE_COMMENT"
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
		public TimelineSectionContext timelineSection() {
			return getRuleContext(TimelineSectionContext.class,0);
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
			setState(62);
			globalSettings();
			setState(63);
			instrumentsSection();
			setState(64);
			clipSection();
			setState(65);
			timelineSection();
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
		public List<SignatureContext> signature() {
			return getRuleContexts(SignatureContext.class);
		}
		public SignatureContext signature(int i) {
			return getRuleContext(SignatureContext.class,i);
		}
		public List<BpmContext> bpm() {
			return getRuleContexts(BpmContext.class);
		}
		public BpmContext bpm(int i) {
			return getRuleContext(BpmContext.class,i);
		}
		public List<TimeshiftContext> timeshift() {
			return getRuleContexts(TimeshiftContext.class);
		}
		public TimeshiftContext timeshift(int i) {
			return getRuleContext(TimeshiftContext.class,i);
		}
		public List<VelocityrandomizationContext> velocityrandomization() {
			return getRuleContexts(VelocityrandomizationContext.class);
		}
		public VelocityrandomizationContext velocityrandomization(int i) {
			return getRuleContext(VelocityrandomizationContext.class,i);
		}
		public List<ResolutionContext> resolution() {
			return getRuleContexts(ResolutionContext.class);
		}
		public ResolutionContext resolution(int i) {
			return getRuleContext(ResolutionContext.class,i);
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
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 454L) != 0)) {
				{
				setState(72);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(67);
					signature();
					}
					break;
				case T__1:
					{
					setState(68);
					bpm();
					}
					break;
				case T__5:
					{
					setState(69);
					timeshift();
					}
					break;
				case T__6:
					{
					setState(70);
					velocityrandomization();
					}
					break;
				case T__7:
					{
					setState(71);
					resolution();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(76);
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
	public static class SignatureContext extends ParserRuleContext {
		public Token globalSignatureValue;
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
			setState(77);
			match(T__0);
			setState(78);
			((SignatureContext)_localctx).globalSignatureValue = match(FRACTION);
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
		public Token globalBpmValue;
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
			setState(80);
			match(T__1);
			setState(81);
			((BpmContext)_localctx).globalBpmValue = match(INT);
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
		public Token tempoChangeValue;
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public List<TerminalNode> WS() { return getTokens(MusicDSLParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MusicDSLParser.WS, i);
		}
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
		enterRule(_localctx, 8, RULE_tempoChange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__2);
			setState(84);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(85);
				match(WS);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			((TempoChangeContext)_localctx).tempoChangeValue = match(INT);
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
	public static class TimeshiftContext extends ParserRuleContext {
		public Token timeshiftValue;
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public TimeshiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeshift; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterTimeshift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitTimeshift(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitTimeshift(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeshiftContext timeshift() throws RecognitionException {
		TimeshiftContext _localctx = new TimeshiftContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_timeshift);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__5);
			setState(94);
			((TimeshiftContext)_localctx).timeshiftValue = match(INT);
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
	public static class VelocityrandomizationContext extends ParserRuleContext {
		public Token velocityrandomizationValue;
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public VelocityrandomizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_velocityrandomization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterVelocityrandomization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitVelocityrandomization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitVelocityrandomization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VelocityrandomizationContext velocityrandomization() throws RecognitionException {
		VelocityrandomizationContext _localctx = new VelocityrandomizationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_velocityrandomization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__6);
			setState(97);
			((VelocityrandomizationContext)_localctx).velocityrandomizationValue = match(INT);
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
	public static class ResolutionContext extends ParserRuleContext {
		public Token resolutionValue;
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public ResolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resolution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterResolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitResolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitResolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResolutionContext resolution() throws RecognitionException {
		ResolutionContext _localctx = new ResolutionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_resolution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__7);
			setState(100);
			((ResolutionContext)_localctx).resolutionValue = match(INT);
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
		enterRule(_localctx, 16, RULE_instrumentsSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__8);
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				instrumentDefinition();
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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
		public Token instrumentName;
		public Token instrumentMidiName;
		public Token volumeInstrument;
		public TerminalNode ID() { return getToken(MusicDSLParser.ID, 0); }
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
		enterRule(_localctx, 18, RULE_instrumentDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			((InstrumentDefinitionContext)_localctx).instrumentName = match(ID);
			setState(109);
			((InstrumentDefinitionContext)_localctx).instrumentMidiName = match(INSTRUMENT);
			setState(110);
			match(T__9);
			setState(111);
			((InstrumentDefinitionContext)_localctx).volumeInstrument = match(INT);
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
		enterRule(_localctx, 20, RULE_clipSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(113);
				clip();
				}
				}
				setState(116); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 );
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
		public Token clipName;
		public BarSequenceContext barDTOS;
		public TerminalNode ID() { return getToken(MusicDSLParser.ID, 0); }
		public DefaultDynamicContext defaultDynamic() {
			return getRuleContext(DefaultDynamicContext.class,0);
		}
		public List<BarSequenceContext> barSequence() {
			return getRuleContexts(BarSequenceContext.class);
		}
		public BarSequenceContext barSequence(int i) {
			return getRuleContext(BarSequenceContext.class,i);
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
		enterRule(_localctx, 22, RULE_clip);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__10);
			setState(119);
			((ClipContext)_localctx).clipName = match(ID);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(120);
				defaultDynamic();
				}
			}

			setState(123);
			match(T__11);
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				((ClipContext)_localctx).barDTOS = barSequence();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__13 );
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
	public static class DefaultDynamicContext extends ParserRuleContext {
		public Token velocity;
		public TerminalNode VELOCITY_SYMBOL() { return getToken(MusicDSLParser.VELOCITY_SYMBOL, 0); }
		public DefaultDynamicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultDynamic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterDefaultDynamic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitDefaultDynamic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitDefaultDynamic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultDynamicContext defaultDynamic() throws RecognitionException {
		DefaultDynamicContext _localctx = new DefaultDynamicContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_defaultDynamic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__12);
			setState(130);
			((DefaultDynamicContext)_localctx).velocity = match(VELOCITY_SYMBOL);
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
		public List<BarContentContext> barContent() {
			return getRuleContexts(BarContentContext.class);
		}
		public BarContentContext barContent(int i) {
			return getRuleContext(BarContentContext.class,i);
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
		enterRule(_localctx, 26, RULE_barSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__13);
			setState(133);
			match(T__14);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 394254L) != 0)) {
				{
				{
				setState(134);
				barContent();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
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
	public static class BarContentContext extends ParserRuleContext {
		public TempoChangeContext tempoChange() {
			return getRuleContext(TempoChangeContext.class,0);
		}
		public BpmContext bpm() {
			return getRuleContext(BpmContext.class,0);
		}
		public VolumeSettingContext volumeSetting() {
			return getRuleContext(VolumeSettingContext.class,0);
		}
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public TrackSequenceContext trackSequence() {
			return getRuleContext(TrackSequenceContext.class,0);
		}
		public EmptyBarContentContext emptyBarContent() {
			return getRuleContext(EmptyBarContentContext.class,0);
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
		enterRule(_localctx, 28, RULE_barContent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(142);
				tempoChange();
				}
				break;
			case T__1:
				{
				setState(143);
				bpm();
				}
				break;
			case T__9:
				{
				setState(144);
				volumeSetting();
				}
				break;
			case T__0:
				{
				setState(145);
				signature();
				}
				break;
			case T__17:
				{
				setState(146);
				trackSequence();
				}
				break;
			case T__16:
				{
				setState(147);
				emptyBarContent();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class EmptyBarContentContext extends ParserRuleContext {
		public EmptyBarContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyBarContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterEmptyBarContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitEmptyBarContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitEmptyBarContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyBarContentContext emptyBarContent() throws RecognitionException {
		EmptyBarContentContext _localctx = new EmptyBarContentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_emptyBarContent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__16);
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
		public Token trackVolume;
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
		enterRule(_localctx, 32, RULE_volumeSetting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__9);
			setState(153);
			((VolumeSettingContext)_localctx).trackVolume = match(INT);
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
		enterRule(_localctx, 34, RULE_trackSequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(155);
					track();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(158); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public Token trackName;
		public TerminalNode ID() { return getToken(MusicDSLParser.ID, 0); }
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
		enterRule(_localctx, 36, RULE_track);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__17);
			setState(161);
			((TrackContext)_localctx).trackName = match(ID);
			setState(162);
			match(T__11);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15569256448L) != 0)) {
				{
				setState(163);
				trackContent();
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
	public static class TrackContentContext extends ParserRuleContext {
		public PercussionSequenceContext percussionSequence() {
			return getRuleContext(PercussionSequenceContext.class,0);
		}
		public NoteSequenceContext noteSequence() {
			return getRuleContext(NoteSequenceContext.class,0);
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
		enterRule(_localctx, 38, RULE_trackContent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(166);
				percussionSequence();
				}
				break;
			case 2:
				{
				setState(167);
				noteSequence();
				}
				break;
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
	public static class NoteSequenceContext extends ParserRuleContext {
		public List<NoteContext> note() {
			return getRuleContexts(NoteContext.class);
		}
		public NoteContext note(int i) {
			return getRuleContext(NoteContext.class,i);
		}
		public List<SilenceContext> silence() {
			return getRuleContexts(SilenceContext.class);
		}
		public SilenceContext silence(int i) {
			return getRuleContext(SilenceContext.class,i);
		}
		public List<ChordContext> chord() {
			return getRuleContexts(ChordContext.class);
		}
		public ChordContext chord(int i) {
			return getRuleContext(ChordContext.class,i);
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
		enterRule(_localctx, 40, RULE_noteSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTE:
				{
				setState(170);
				note();
				}
				break;
			case SILENCE:
				{
				setState(171);
				silence();
				}
				break;
			case CHORD:
				{
				setState(172);
				chord();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(175);
				match(T__18);
				setState(179);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOTE:
					{
					setState(176);
					note();
					}
					break;
				case SILENCE:
					{
					setState(177);
					silence();
					}
					break;
				case CHORD:
					{
					setState(178);
					chord();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(185);
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
	public static class NoteDynamicContext extends ParserRuleContext {
		public Token velocity;
		public TerminalNode VELOCITY_SYMBOL() { return getToken(MusicDSLParser.VELOCITY_SYMBOL, 0); }
		public NoteDynamicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteDynamic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterNoteDynamic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitNoteDynamic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitNoteDynamic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteDynamicContext noteDynamic() throws RecognitionException {
		NoteDynamicContext _localctx = new NoteDynamicContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_noteDynamic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			((NoteDynamicContext)_localctx).velocity = match(VELOCITY_SYMBOL);
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
	public static class NoteDurationContext extends ParserRuleContext {
		public Token length;
		public TerminalNode FRACTION() { return getToken(MusicDSLParser.FRACTION, 0); }
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public NoteDurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteDuration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterNoteDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitNoteDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitNoteDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteDurationContext noteDuration() throws RecognitionException {
		NoteDurationContext _localctx = new NoteDurationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_noteDuration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__19);
			setState(189);
			((NoteDurationContext)_localctx).length = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FRACTION) ) {
				((NoteDurationContext)_localctx).length = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(190);
			match(T__20);
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
		public Token noteName;
		public TerminalNode NOTE() { return getToken(MusicDSLParser.NOTE, 0); }
		public NoteDurationContext noteDuration() {
			return getRuleContext(NoteDurationContext.class,0);
		}
		public NoteDynamicContext noteDynamic() {
			return getRuleContext(NoteDynamicContext.class,0);
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
		enterRule(_localctx, 46, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			((NoteContext)_localctx).noteName = match(NOTE);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(193);
				noteDuration();
				}
			}

			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VELOCITY_SYMBOL) {
				{
				setState(196);
				noteDynamic();
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
	public static class ChordContext extends ParserRuleContext {
		public Token chordName;
		public TerminalNode CHORD() { return getToken(MusicDSLParser.CHORD, 0); }
		public NoteDynamicContext noteDynamic() {
			return getRuleContext(NoteDynamicContext.class,0);
		}
		public NoteDurationContext noteDuration() {
			return getRuleContext(NoteDurationContext.class,0);
		}
		public ChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitChord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitChord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChordContext chord() throws RecognitionException {
		ChordContext _localctx = new ChordContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			((ChordContext)_localctx).chordName = match(CHORD);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VELOCITY_SYMBOL) {
				{
				setState(200);
				noteDynamic();
				}
			}

			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(203);
				noteDuration();
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
	public static class SilenceContext extends ParserRuleContext {
		public TerminalNode SILENCE() { return getToken(MusicDSLParser.SILENCE, 0); }
		public NoteDurationContext noteDuration() {
			return getRuleContext(NoteDurationContext.class,0);
		}
		public SilenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_silence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterSilence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitSilence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitSilence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SilenceContext silence() throws RecognitionException {
		SilenceContext _localctx = new SilenceContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_silence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(SILENCE);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(207);
				noteDuration();
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
	public static class TimelineSectionContext extends ParserRuleContext {
		public TimelineSequenceContext timelineSequence() {
			return getRuleContext(TimelineSequenceContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(MusicDSLParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MusicDSLParser.WS, i);
		}
		public TimelineSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timelineSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterTimelineSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitTimelineSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitTimelineSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimelineSectionContext timelineSection() throws RecognitionException {
		TimelineSectionContext _localctx = new TimelineSectionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_timelineSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__21);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(211);
				match(WS);
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217);
			timelineSequence();
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
	public static class TimelineSequenceContext extends ParserRuleContext {
		public List<TimelineClipContext> timelineClip() {
			return getRuleContexts(TimelineClipContext.class);
		}
		public TimelineClipContext timelineClip(int i) {
			return getRuleContext(TimelineClipContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(MusicDSLParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MusicDSLParser.WS, i);
		}
		public TimelineSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timelineSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterTimelineSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitTimelineSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitTimelineSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimelineSequenceContext timelineSequence() throws RecognitionException {
		TimelineSequenceContext _localctx = new TimelineSequenceContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_timelineSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(219);
				timelineClip();
				}
				}
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(224);
				match(WS);
				}
				}
				setState(229);
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
	public static class TimelineClipContext extends ParserRuleContext {
		public Token clipName;
		public Token repeatNumber;
		public TerminalNode ID() { return getToken(MusicDSLParser.ID, 0); }
		public TerminalNode INT() { return getToken(MusicDSLParser.INT, 0); }
		public List<TerminalNode> WS() { return getTokens(MusicDSLParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(MusicDSLParser.WS, i);
		}
		public TimelineClipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timelineClip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterTimelineClip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitTimelineClip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitTimelineClip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimelineClipContext timelineClip() throws RecognitionException {
		TimelineClipContext _localctx = new TimelineClipContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_timelineClip);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			((TimelineClipContext)_localctx).clipName = match(ID);
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(231);
					match(WS);
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(237);
				match(T__22);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(238);
					match(WS);
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(244);
				((TimelineClipContext)_localctx).repeatNumber = match(INT);
				}
				break;
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
	public static class PercussionSequenceContext extends ParserRuleContext {
		public List<PercussionElementContext> percussionElement() {
			return getRuleContexts(PercussionElementContext.class);
		}
		public PercussionElementContext percussionElement(int i) {
			return getRuleContext(PercussionElementContext.class,i);
		}
		public PercussionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_percussionSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).enterPercussionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicDSLListener ) ((MusicDSLListener)listener).exitPercussionSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicDSLVisitor ) return ((MusicDSLVisitor<? extends T>)visitor).visitPercussionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PercussionSequenceContext percussionSequence() throws RecognitionException {
		PercussionSequenceContext _localctx = new PercussionSequenceContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_percussionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			percussionElement();
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(248);
				match(T__18);
				setState(249);
				percussionElement();
				}
				}
				setState(254);
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
	public static class PercussionElementContext extends ParserRuleContext {
		public TerminalNode PERCUSSION() { return getToken(MusicDSLParser.PERCUSSION, 0); }
		public NoteDurationContext noteDuration() {
			return getRuleContext(NoteDurationContext.class,0);
		}
		public NoteDynamicContext noteDynamic() {
			return getRuleContext(NoteDynamicContext.class,0);
		}
		public SilenceContext silence() {
			return getRuleContext(SilenceContext.class,0);
		}
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
		enterRule(_localctx, 60, RULE_percussionElement);
		int _la;
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERCUSSION:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				match(PERCUSSION);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(256);
					noteDuration();
					}
				}

				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VELOCITY_SYMBOL) {
					{
					setState(259);
					noteDynamic();
					}
				}

				}
				break;
			case SILENCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				silence();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\u0004\u0001$\u010a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001I\b\u0001"+
		"\n\u0001\f\u0001L\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"W\b\u0004\n\u0004\f\u0004Z\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0004\bi\b\b\u000b\b\f\bj\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0004\ns\b\n\u000b\n\f\nt\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000bz\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0004\u000b~\b\u000b\u000b\u000b\f\u000b\u007f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u0088\b\r\n\r\f\r\u008b\t\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0095\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011\u009d\b\u0011\u000b\u0011"+
		"\f\u0011\u009e\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00a5\b\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u00a9\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00ae\b\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00b4\b\u0014\u0005\u0014\u00b6"+
		"\b\u0014\n\u0014\f\u0014\u00b9\t\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u00c3\b\u0017\u0001\u0017\u0003\u0017\u00c6\b\u0017\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u00ca\b\u0018\u0001\u0018\u0003\u0018\u00cd\b\u0018"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u00d1\b\u0019\u0001\u001a\u0001\u001a"+
		"\u0005\u001a\u00d5\b\u001a\n\u001a\f\u001a\u00d8\t\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0004\u001b\u00dd\b\u001b\u000b\u001b\f\u001b\u00de"+
		"\u0001\u001b\u0005\u001b\u00e2\b\u001b\n\u001b\f\u001b\u00e5\t\u001b\u0001"+
		"\u001c\u0001\u001c\u0005\u001c\u00e9\b\u001c\n\u001c\f\u001c\u00ec\t\u001c"+
		"\u0001\u001c\u0001\u001c\u0005\u001c\u00f0\b\u001c\n\u001c\f\u001c\u00f3"+
		"\t\u001c\u0001\u001c\u0003\u001c\u00f6\b\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0005\u001d\u00fb\b\u001d\n\u001d\f\u001d\u00fe\t\u001d\u0001"+
		"\u001e\u0001\u001e\u0003\u001e\u0102\b\u001e\u0001\u001e\u0003\u001e\u0105"+
		"\b\u001e\u0001\u001e\u0003\u001e\u0108\b\u001e\u0001\u001e\u0000\u0000"+
		"\u001f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<\u0000\u0002\u0001\u0000\u0004\u0005"+
		"\u0002\u0000\u0018\u0018\u001a\u001a\u0111\u0000>\u0001\u0000\u0000\u0000"+
		"\u0002J\u0001\u0000\u0000\u0000\u0004M\u0001\u0000\u0000\u0000\u0006P"+
		"\u0001\u0000\u0000\u0000\bS\u0001\u0000\u0000\u0000\n]\u0001\u0000\u0000"+
		"\u0000\f`\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000\u0000\u0010"+
		"f\u0001\u0000\u0000\u0000\u0012l\u0001\u0000\u0000\u0000\u0014r\u0001"+
		"\u0000\u0000\u0000\u0016v\u0001\u0000\u0000\u0000\u0018\u0081\u0001\u0000"+
		"\u0000\u0000\u001a\u0084\u0001\u0000\u0000\u0000\u001c\u0094\u0001\u0000"+
		"\u0000\u0000\u001e\u0096\u0001\u0000\u0000\u0000 \u0098\u0001\u0000\u0000"+
		"\u0000\"\u009c\u0001\u0000\u0000\u0000$\u00a0\u0001\u0000\u0000\u0000"+
		"&\u00a8\u0001\u0000\u0000\u0000(\u00ad\u0001\u0000\u0000\u0000*\u00ba"+
		"\u0001\u0000\u0000\u0000,\u00bc\u0001\u0000\u0000\u0000.\u00c0\u0001\u0000"+
		"\u0000\u00000\u00c7\u0001\u0000\u0000\u00002\u00ce\u0001\u0000\u0000\u0000"+
		"4\u00d2\u0001\u0000\u0000\u00006\u00dc\u0001\u0000\u0000\u00008\u00e6"+
		"\u0001\u0000\u0000\u0000:\u00f7\u0001\u0000\u0000\u0000<\u0107\u0001\u0000"+
		"\u0000\u0000>?\u0003\u0002\u0001\u0000?@\u0003\u0010\b\u0000@A\u0003\u0014"+
		"\n\u0000AB\u00034\u001a\u0000B\u0001\u0001\u0000\u0000\u0000CI\u0003\u0004"+
		"\u0002\u0000DI\u0003\u0006\u0003\u0000EI\u0003\n\u0005\u0000FI\u0003\f"+
		"\u0006\u0000GI\u0003\u000e\u0007\u0000HC\u0001\u0000\u0000\u0000HD\u0001"+
		"\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000K\u0003\u0001\u0000\u0000\u0000LJ\u0001"+
		"\u0000\u0000\u0000MN\u0005\u0001\u0000\u0000NO\u0005\u001a\u0000\u0000"+
		"O\u0005\u0001\u0000\u0000\u0000PQ\u0005\u0002\u0000\u0000QR\u0005\u0018"+
		"\u0000\u0000R\u0007\u0001\u0000\u0000\u0000ST\u0005\u0003\u0000\u0000"+
		"TX\u0007\u0000\u0000\u0000UW\u0005#\u0000\u0000VU\u0001\u0000\u0000\u0000"+
		"WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000Y[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[\\\u0005\u0018"+
		"\u0000\u0000\\\t\u0001\u0000\u0000\u0000]^\u0005\u0006\u0000\u0000^_\u0005"+
		"\u0018\u0000\u0000_\u000b\u0001\u0000\u0000\u0000`a\u0005\u0007\u0000"+
		"\u0000ab\u0005\u0018\u0000\u0000b\r\u0001\u0000\u0000\u0000cd\u0005\b"+
		"\u0000\u0000de\u0005\u0018\u0000\u0000e\u000f\u0001\u0000\u0000\u0000"+
		"fh\u0005\t\u0000\u0000gi\u0003\u0012\t\u0000hg\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000k\u0011\u0001\u0000\u0000\u0000lm\u0005\"\u0000\u0000mn\u0005\u001c"+
		"\u0000\u0000no\u0005\n\u0000\u0000op\u0005\u0018\u0000\u0000p\u0013\u0001"+
		"\u0000\u0000\u0000qs\u0003\u0016\u000b\u0000rq\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000u\u0015\u0001\u0000\u0000\u0000vw\u0005\u000b\u0000\u0000wy\u0005"+
		"\"\u0000\u0000xz\u0003\u0018\f\u0000yx\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0005\f\u0000\u0000|~\u0003"+
		"\u001a\r\u0000}|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0017\u0001\u0000\u0000\u0000\u0081\u0082\u0005\r\u0000\u0000\u0082\u0083"+
		"\u0005\u001b\u0000\u0000\u0083\u0019\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0005\u000e\u0000\u0000\u0085\u0089\u0005\u000f\u0000\u0000\u0086\u0088"+
		"\u0003\u001c\u000e\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u008b"+
		"\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0001\u0000\u0000\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0089"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u0010\u0000\u0000\u008d\u001b"+
		"\u0001\u0000\u0000\u0000\u008e\u0095\u0003\b\u0004\u0000\u008f\u0095\u0003"+
		"\u0006\u0003\u0000\u0090\u0095\u0003 \u0010\u0000\u0091\u0095\u0003\u0004"+
		"\u0002\u0000\u0092\u0095\u0003\"\u0011\u0000\u0093\u0095\u0003\u001e\u000f"+
		"\u0000\u0094\u008e\u0001\u0000\u0000\u0000\u0094\u008f\u0001\u0000\u0000"+
		"\u0000\u0094\u0090\u0001\u0000\u0000\u0000\u0094\u0091\u0001\u0000\u0000"+
		"\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u001d\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u0011\u0000"+
		"\u0000\u0097\u001f\u0001\u0000\u0000\u0000\u0098\u0099\u0005\n\u0000\u0000"+
		"\u0099\u009a\u0005\u0018\u0000\u0000\u009a!\u0001\u0000\u0000\u0000\u009b"+
		"\u009d\u0003$\u0012\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f#\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005"+
		"\u0012\u0000\u0000\u00a1\u00a2\u0005\"\u0000\u0000\u00a2\u00a4\u0005\f"+
		"\u0000\u0000\u00a3\u00a5\u0003&\u0013\u0000\u00a4\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5%\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a9\u0003:\u001d\u0000\u00a7\u00a9\u0003(\u0014\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9\'\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ae\u0003.\u0017\u0000\u00ab\u00ae\u00032\u0019"+
		"\u0000\u00ac\u00ae\u00030\u0018\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ae\u00b7\u0001\u0000\u0000\u0000\u00af\u00b3\u0005\u0013\u0000\u0000"+
		"\u00b0\u00b4\u0003.\u0017\u0000\u00b1\u00b4\u00032\u0019\u0000\u00b2\u00b4"+
		"\u00030\u0018\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b5\u00af\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b8)\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0005\u001b\u0000\u0000\u00bb+\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005\u0014\u0000\u0000\u00bd\u00be\u0007\u0001\u0000"+
		"\u0000\u00be\u00bf\u0005\u0015\u0000\u0000\u00bf-\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c2\u0005\u001d\u0000\u0000\u00c1\u00c3\u0003,\u0016\u0000\u00c2"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c6\u0003*\u0015\u0000\u00c5\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6/\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c9\u0005\u001f\u0000\u0000\u00c8\u00ca\u0003"+
		"*\u0015\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb\u00cd\u0003,\u0016"+
		"\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cd1\u0001\u0000\u0000\u0000\u00ce\u00d0\u0005 \u0000\u0000\u00cf"+
		"\u00d1\u0003,\u0016\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d13\u0001\u0000\u0000\u0000\u00d2\u00d6\u0005"+
		"\u0016\u0000\u0000\u00d3\u00d5\u0005#\u0000\u0000\u00d4\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d9\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00da\u00036\u001b"+
		"\u0000\u00da5\u0001\u0000\u0000\u0000\u00db\u00dd\u00038\u001c\u0000\u00dc"+
		"\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de"+
		"\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e0\u00e2\u0005#\u0000\u0000\u00e1\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e47\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00f5\u0005"+
		"\"\u0000\u0000\u00e7\u00e9\u0005#\u0000\u0000\u00e8\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ed\u00f1\u0005\u0017"+
		"\u0000\u0000\u00ee\u00f0\u0005#\u0000\u0000\u00ef\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f3\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f6\u0005\u0018\u0000"+
		"\u0000\u00f5\u00ea\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f69\u0001\u0000\u0000\u0000\u00f7\u00fc\u0003<\u001e\u0000\u00f8"+
		"\u00f9\u0005\u0013\u0000\u0000\u00f9\u00fb\u0003<\u001e\u0000\u00fa\u00f8"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd;\u0001"+
		"\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u0101\u0005"+
		"!\u0000\u0000\u0100\u0102\u0003,\u0016\u0000\u0101\u0100\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0104\u0001\u0000\u0000"+
		"\u0000\u0103\u0105\u0003*\u0015\u0000\u0104\u0103\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0108\u0001\u0000\u0000\u0000"+
		"\u0106\u0108\u00032\u0019\u0000\u0107\u00ff\u0001\u0000\u0000\u0000\u0107"+
		"\u0106\u0001\u0000\u0000\u0000\u0108=\u0001\u0000\u0000\u0000\u001eHJ"+
		"Xjty\u007f\u0089\u0094\u009e\u00a4\u00a8\u00ad\u00b3\u00b7\u00c2\u00c5"+
		"\u00c9\u00cc\u00d0\u00d6\u00de\u00e3\u00ea\u00f1\u00f5\u00fc\u0101\u0104"+
		"\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}