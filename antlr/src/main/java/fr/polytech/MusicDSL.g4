grammar MusicDSL;

// Parser Rules
musicComposition : globalSettings instrumentsSection clipSection mainSection;

globalSettings : (signature | bpm | tempoChange)*;

signature : 'signature' FRACTION;
bpm : 'bpm' INT;
tempoChange : 'tempo' ('+' | '-') INT;

// ----------------- INSTRUMENTS -----------------
instrumentsSection : 'Instruments:' instrumentDefinition+;
instrumentDefinition : ID INSTRUMENT 'volume' INT;

// ----------------- CLIP -----------------
clipSection : 'clip' clip+;
clip : ID ':' barSequence;

// ----------------- BAR -----------------
barSequence : 'bar' '[' barContent* ']';
barContent : (tempoChange | volumeSetting | signature | trackSequence);

// ----------------- TRACK -----------------
trackSequence : track+;
// tempoChange : 'LINEAR|' 'tempo' SIGNED_INT;
volumeSetting : 'volume' INT;
// inherited bpm
// inherited signature
track : 'track' ID ':' trackContent;
trackContent : (noteSequence | percussionSequence);

// ----------------- NOTE -----------------
noteSequence : (note | silence | chord) (',' (note | silence | chord))*;
note : NOTE dynamicSetting? duration?;
chord : CHORD dynamicSetting? duration?;
silence : SILENCE duration?;

dynamicSetting : VELOCITY_SYMBOL;
duration : '(' FRACTION ')';

percussionSequence : percussionElement+;
percussionElement : PERCUSSION (',' PERCUSSION)*;

mainSection : mainSequence;
mainSequence : clipInstance (clipInstance)*;
clipInstance : ID ('x' INT)?;

// Lexer Rules
FRACTION : INT '/' INT;
SIGNED_INT : '-'? INT;
INT : DIGIT+;
fragment DIGIT : [0-9];

VELOCITY_SYMBOL : 'ppp' | 'pp' | 'p' | 'mp' | 'mf' | 'f' | 'ff' | 'fff';

INSTRUMENT : 'ACOUSTIC_GRAND_PIANO' | 'TRUMPET' | 'DRUMS' | 'OCARINA' | 'PIANO' | 'HARP' | 'VIOLIN' | 'CELLO' | 'FLUTE' | 'SAXOPHONE' | 'GUITAR' | 'BASS';

NOTE : [A-G] ( '#' | 'b' )? [0-9];
CHORD : [A-G] ( '#' | 'b' )? [0-9] ('-' [A-G] ( '#' | 'b' )? [0-9])+;
SILENCE : 'SILENCE';

PERCUSSION : 'KICK' | 'CLAP' | 'SNARE_DRUM' | 'CLOSED_HI_HAT' | 'OPEN_HI_HAT' | 'CRASH_CYMBAL' | 'RIDE_CYMBAL' | 'TAMBOURINE' | 'COWBELL' | 'MARACAS' | 'HIGH_BONGO' | 'LOW_BONGO' | 'MUTE_HIGH_CONGA' | 'OPEN_HIGH_CONGA' | 'LOW_CONGA' | 'HIGH_TIMBALE' | 'LOW_TIMBALE' | 'HIGH_AGOGO' | 'LOW_AGOGO' | 'CABASA' | 'SHORT_WHISTLE' | 'LONG_WHISTLE' | 'SHORT_GUIRO' | 'LONG_GUIRO' | 'CLAVES' | 'HIGH_WOOD_BLOCK' | 'LOW_WOOD_BLOCK' | 'MUTE_CUICA' | 'OPEN_CUICA' | 'MUTE_TRIANGLE' | 'OPEN_TRIANGLE';

ID : [a-zA-Z_][a-zA-Z0-9_]*;

WS : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
