grammar MusicDSL;

// Parser Rules
musicComposition : globalSettings instrumentsSection clipSection timelineSection?; // mainSection;

globalSettings : (signature | bpm | timeshift | velocityrandomization | resolution)*;

signature : 'signature' globalSignatureValue=FRACTION;
bpm : 'bpm' globalBpmValue=INT;
tempoChange : 'tempo' ('+' | '-') WS* tempoChangeValue=INT;
timeshift : 'timeshift' timeshiftValue=INT;
velocityrandomization : 'velocityrandomization' velocityrandomizationValue=INT;
resolution : 'resolution' resolutionValue=INT;

// ----------------- INSTRUMENTS -----------------
instrumentsSection : 'Instruments:' instrumentDefinition+;
instrumentDefinition : instrumentName=ID instrumentMidiName=INSTRUMENT 'volume' volumeInstrument=INT;

// ----------------- CLIP -----------------
clipSection : clip+;
clip : 'clip' clipName=ID defaultDynamic? ':' bars=barSequence+;
defaultDynamic : '<-' velocity=VELOCITY_SYMBOL;

// ----------------- BAR -----------------
barSequence : 'bar' '[' barContent* ']';
barContent : (tempoChange | bpm | volumeSetting | signature | trackSequence | emptyBarContent);
emptyBarContent : 'EMPTY';

// ----------------- TRACK -----------------
// tempoChange : 'LINEAR|' 'tempo' SIGNED_INT;
volumeSetting : 'volume' trackVolume=INT;
// inherited bpm
// inherited signature
trackSequence : track+;
track : 'track' trackName=ID ':' trackContent?;
trackContent : (noteSequence | percussionSequence);
// ----------------- NOTE -----------------
noteSequence : (note | silence | chord) (',' (note | silence | chord))*;
noteDynamic : velocity=VELOCITY_SYMBOL;
noteDuration : '(' length=(FRACTION | INT) ')';
note : noteName=NOTE noteDynamic? noteDuration?;
chord : chordName=CHORD noteDynamic? noteDuration?;
silence : SILENCE noteDuration?;

// ----------------- TIMELINE -----------------
timelineSection : 'Timeline:' WS* timelineSequence;
timelineSequence : timelineClip+ WS*;
timelineClip : clipName=ID (WS* 'x' WS* repeatNumber=INT)?;

// ----------------- DRUMS -----------------
percussionSequence : percussionElement+;
percussionElement : PERCUSSION noteDuration? | silence;

// Lexer Rules
fragment DIGIT : [0-9];
INT : DIGIT+;
SIGNED_INT : '-'? INT;
FRACTION : INT '/' INT;

VELOCITY_SYMBOL : 'ppp' | 'pp' | 'p' | 'mp' | 'mf' | 'f' | 'ff' | 'fff';

//     ACOUSTIC_GRAND_PIANO(0), BRIGHT_ACOUSTIC_PIANO(1), ELECTRIC_GRAND_PIANO(2), HONKY_TONK_PIANO(3), ELECTRIC_PIANO_1(4), ELECTRIC_PIANO_2(5), HARPSICHORD(6), CLAVI(7), CELESTA(8), GLOCKENSPIEL(9), MUSIC_BOX(10), VIBRAPHONE(11), MARIMBA(12), XYLOPHONE(13), TUBULAR_BELLS(14), DULCIMER(15), DRAWBAR_ORGAN(16), PERCUSSIVE_ORGAN(17), ROCK_ORGAN(18), CHURCH_ORGAN(19), REED_ORGAN(20), ACCORDION(21), HARMONICA(22), TANGO_ACCORDION(23), ACOUSTIC_GUITAR_NYLON(24), ACOUSTIC_GUITAR_STEEL(25), ELECTRIC_GUITAR_JAZZ(26), ELECTRIC_GUITAR_CLEAN(27), ELECTRIC_GUITAR_MUTED(28), OVERDRIVEN_GUITAR(29), DISTORTION_GUITAR(30), GUITAR_HARMONICS(31), ACOUSTIC_BASS(32), ELECTRIC_BASS_FINGER(33), ELECTRIC_BASS_PICK(34), FRETLESS_BASS(35), SLAP_BASS_1(36), SLAP_BASS_2(37), SYNTH_BASS_1(38), SYNTH_BASS_2(39), VIOLIN(40), VIOLA(41), CELLO(42), CONTRABASS(43), TREMOLO_STRINGS(44), PIZZICATO_STRINGS(45), ORCHESTRAL_HARP(46), TIMPANI(47), STRING_ENSEMBLE_1(48), STRING_ENSEMBLE_2(49), SYNTH_STRINGS_1(50), SYNTH_STRINGS_2(51), CHOIR_AAHS(52), VOICE_OOHS(53), SYNTH_VOICE(54), ORCHESTRA_HIT(55), TRUMPET(56), TROMBONE(57), TUBA(58), MUTED_TRUMPET(59), FRENCH_HORN(60), BRASS_SECTION(61), SYNTH_BRASS_1(62), SYNTH_BRASS_2(63), SOPRANO_SAX(64), ALTO_SAX(65), TENOR_SAX(66), BARITONE_SAX(67), OBOE(68), ENGLISH_HORN(69), BASSOON(70), CLARINET(71), PICCOLO(72), FLUTE(73), RECORDER(74), PAN_FLUTE(75), BLOWN_BOTTLE(76), SHAKUHACHI(77), WHISTLE(78), OCARINA(79), LEAD_1_SQUARE(80), LEAD_2_SAWTOOTH(81), LEAD_3_CALLIOPE(82), LEAD_4_CHIFF(83), LEAD_5_CHARANG(84), LEAD_6_VOICE(85), LEAD_7_FIFTHS(86), LEAD_8_BASS_LEAD(87), PAD_1_NEW_AGE(88), PAD_2_WARM(89), PAD_3_POLYSYNTH(90), PAD_4_CHOIR(91), PAD_5_BOWED(92), PAD_6_METALLIC(93), PAD_7_HALO(94), PAD_8_SWEEP(95), FX_1_RAIN(96), FX_2_SOUNDTRACK(97), FX_3_CRYSTAL(98), FX_4_ATMOSPHERE(99), FX_5_BRIGHTNESS(100), FX_6_GOBLINS(101), FX_7_ECHOES(102), FX_8_SCI_FI(103), SITAR(104), BANJO(105), SHAMISEN(106), KOTO(107), KALIMBA(108), BAG_PIPE(109), FIDDLE(110), SHANAI(111), TINKLE_BELL(112), AGOGO(113), STEEL_DRUMS(114), WOODBLOCK(115), TAIKO_DRUM(116), MELODIC_TOM(117), SYNTH_DRUM(118), REVERSE_CYMBAL(119), GUITAR_FRET_NOISE(120), BREATH_NOISE(121), SEASHORE(122), BIRD_TWEET(123), TELEPHONE_RING(124), HELICOPTER(125), APPLAUSE(126), GUNSHOT(127);
INSTRUMENT :'ACOUSTIC_GRAND_PIANO' | 'BRIGHT_ACOUSTIC_PIANO' | 'ELECTRIC_GRAND_PIANO' |
            'HONKY_TONK_PIANO' |  'ELECTRIC_PIANO_1' | 'ELECTRIC_PIANO_2' | 'HARPSICHORD' |
            'CLAVI' | 'CELESTA' | 'GLOCKENSPIEL' | 'MUSIC_BOX' | 'VIBRAPHONE' | 'MARIMBA' |
            'XYLOPHONE' | 'TUBULAR_BELLS' | 'DULCIMER' | 'DRAWBAR_ORGAN' | 'PERCUSSIVE_ORGAN' |
            'ROCK_ORGAN' | 'CHURCH_ORGAN' | 'REED_ORGAN' | 'ACCORDION' | 'HARMONICA' |
            'TANGO_ACCORDION' | 'ACOUSTIC_GUITAR_NYLON' | 'ACOUSTIC_GUITAR_STEEL' | 'ELECTRIC_GUITAR_JAZZ' |
            'ELECTRIC_GUITAR_CLEAN' | 'ELECTRIC_GUITAR_MUTED' | 'OVERDRIVEN_GUITAR' | 'DISTORTION_GUITAR' |
            'GUITAR_HARMONICS' | 'ACOUSTIC_BASS' | 'ELECTRIC_BASS_FINGER' | 'ELECTRIC_BASS_PICK' |
            'FRETLESS_BASS' | 'SLAP_BASS_1' | 'SLAP_BASS_2' | 'SYNTH_BASS_1' | 'SYNTH_BASS_2' | 'VIOLIN' |
            'VIOLA' | 'CELLO' | 'CONTRABASS' | 'TREMOLO_STRINGS' | 'PIZZICATO_STRINGS' | 'ORCHESTRAL_HARP' |
            'TIMPANI' | 'STRING_ENSEMBLE_1' | 'STRING_ENSEMBLE_2' | 'SYNTH_STRINGS_1' | 'SYNTH_STRINGS_2' |
            'CHOIR_AAHS' | 'VOICE_OOHS' | 'SYNTH_VOICE' | 'ORCHESTRA_HIT' | 'TRUMPET' | 'TROMBONE' |
            'TUBA' | 'MUTED_TRUMPET' | 'FRENCH_HORN' | 'BRASS_SECTION' | 'SYNTH_BRASS_1' | 'SYNTH_BRASS_2' |
            'SOPRANO_SAX' | 'ALTO_SAX' | 'TENOR_SAX' | 'BARITONE_SAX' | 'OBOE' | 'ENGLISH_HORN' | 'BASSOON' |
            'CLARINET' | 'PICCOLO' | 'FLUTE' | 'RECORDER' | 'PAN_FLUTE' | 'BLOWN_BOTTLE' | 'SHAKUHACHI' |
            'WHISTLE' | 'OCARINA' | 'LEAD_1_SQUARE' | 'LEAD_2_SAWTOOTH' | 'LEAD_3_CALLIOPE' | 'LEAD_4_CHIFF' |
            'LEAD_5_CHARANG' | 'LEAD_6_VOICE' | 'LEAD_7_FIFTHS' | 'LEAD_8_BASS_LEAD' | 'PAD_1_NEW_AGE' |
            'PAD_2_WARM' | 'PAD_3_POLYSYNTH' | 'PAD_4_CHOIR' | 'PAD_5_BOWED' | 'PAD_6_METALLIC' |
            'PAD_7_HALO' | 'PAD_8_SWEEP' | 'FX_1_RAIN' | 'FX_2_SOUNDTRACK' | 'FX_3_CRYSTAL' |
            'FX_4_ATMOSPHERE' | 'FX_5_BRIGHTNESS0' | 'FX_6_GOBLINS1' | 'FX_7_ECHOES2' | 'FX_8_SCI_FI3' |
            'SITAR4' | 'BANJO5' | 'SHAMISEN6' | 'KOTO7' | 'KALIMBA8' | 'BAG_PIPE9' | 'FIDDLE0' |
            'SHANAI1' | 'TINKLE_BELL2' | 'AGOGO3' | 'STEEL_DRUMS4' | 'WOODBLOCK5' | 'TAIKO_DRUM6' |
            'MELODIC_TOM7' | 'SYNTH_DRUM8' | 'REVERSE_CYMBAL9' | 'GUITAR_FRET_NOISE0' | 'BREATH_NOISE1' |
            'SEASHORE2' | 'BIRD_TWEET3' | 'TELEPHONE_RING4' | 'HELICOPTER5' | 'APPLAUSE6' | 'GUNSHOT7';

NOTE : [A-G] ( '#' | 'b' )? [0-9] | LATIN_NOTE;
LATIN_NOTE : ([Dd][Oo] | [Rr][Ee] | [Mm][Ii] | [Ff][Aa] | [Ss][Oo][Ll] | [Ll][Aa] | [Ss][Ii]) ( '#' | 'b' )? [0-9];
// LATIN_NOTE : ('do' | 're' | 'mi' | 'fa' | 'sol' | 'la' | 'si') ( '#' | 'b' )? [0-9];
CHORD : NOTE ('-' NOTE)+;

SILENCE : 'SILENCE' | 'REST' | 'PAUSE' | 'SILENT' | 'MUTE'
| 'silence' | 'rest' | 'pause' | 'silent' | 'mute';

PERCUSSION :
 'ACOUSTIC_SOUND' | 'ACOUSTIC_BASS_DRUM' | 'BASS_DRUM' | 'KICK' | 'KICK_DRUM' | 'BD' // KICK
| 'BASS_DRUM_1' | 'BD_1'
| 'SIDE_STICK' | 'RIMSHOT'
| 'SNARE_DRUM' | 'SNARE' | 'SD'
| 'HAND_CLAP' | 'CLAP'
| 'ELECTRIC_SNARE'
| 'LOW_FLOOR_TOM'
| 'CLOSED_HI_HAT' | 'CLOSED_HIHAT' | 'CH'
| 'HIGH_FLOOR_TOM'
| 'PEDAL_HI_HAT'| 'PEDAL_HIHAT' | 'PH'
| 'LOW_TOM'
| 'OPEN_HI_HAT' | 'OPEN_HIHAT' | 'OH'
| 'CRASH_CYMBAL_1'
| 'CRASH' | 'CRASH_CYMBAL' | 'CC'
| 'HIGH_TOM'
| 'RIDE_CYMBAL_1' | 'RIDE' | 'RIDE_CYMBAL' | 'RC'
| 'CHINESE_CYMBAL'
| 'RIDE_BELL'
| 'TAMBOURINE'
| 'SPLASH_CYMBAL'
| 'COWBELL'
| 'CRASH_CYMBAL_2'
| 'VIBRASLAP'
| 'RIDE_CYMBAL_2'
| 'HI_BONGO' | 'TOM'
| 'LOW_BONGO'
| 'MUTE_HI_CONGA'
| 'OPEN_HI_CONGA'
| 'LOW_CONGA'
| 'HIGH_TIMBALE'
| 'LOW_TIMBALE'
| 'HIGH_AGOGO'
| 'LOW_AGOGO'
| 'CABASA'
| 'MARACAS'
| 'SHORT_WHISTLE'
| 'LONG_WHISTLE'
| 'SHORT_GUIRO'
| 'LONG_GUIRO'
| 'CLAVES'
| 'HI_WOOD_BLOCK'
| 'LOW_WOOD_BLOCK'
| 'MUTE_CUICA'
| 'OPEN_CUICA'
| 'MUTE_TRIANGLE'
| 'OPEN_TRIANGLE'
;

ID : [a-zA-Z_][a-zA-Z0-9_]*;

WS : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
