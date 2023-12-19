grammar MusicDSL;

// Parser Rules
musicComposition : globalSettings instrumentsSection clipSection mainSection;

globalSettings : (signature | bpm | tempoChange)*;

signature : 'signature' globalSignatureValue=FRACTION;
bpm : 'bpm' globalBpmValue=INT;
tempoChange : 'tempo' ('+' | '-') tempoChangeValue=INT;

// ----------------- INSTRUMENTS -----------------
instrumentsSection : 'Instruments:' instrumentDefinition+;
instrumentDefinition : instrumentName=ID instrumentMidiName=INSTRUMENT 'volume' volumeInstrument=INT;

// ----------------- CLIP -----------------
clipSection : 'clip' clip+;
clip : clipName=ID ':' bars=barSequence;

// ----------------- BAR -----------------
barSequence : 'bar' '[' barContent* ']';
barContent : (tempoChange | volumeSetting | signature | trackSequence);

// ----------------- TRACK -----------------
trackSequence : track+;
// tempoChange : 'LINEAR|' 'tempo' SIGNED_INT;
volumeSetting : 'volume' trackVolume=INT;
// inherited bpm
// inherited signature
track : 'track' trackName=ID ':' trackContent;
trackContent : (noteSequence | percussionSequence);

// ----------------- NOTE -----------------
noteSequence : (note | silence | chord) (',' (note | silence | chord))*;
note : noteName=NOTE noteDynamic? noteDuration?;
chord : chordName=CHORD noteDynamic? noteDuration?;
silence : SILENCE noteDuration?;

noteDynamic : velocity=VELOCITY_SYMBOL;
noteDuration : '(' fraction=FRACTION ')';

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

PERCUSSION : 'KICK' | 'SNARE' | 'CLOSED_HIHAT' | 'OPEN_HIHAT' | 'CRASH' | 'RIDE' | 'TOM' | 'RIMSHOT' | 'CLAP' | 'COWBELL' | 'MARACAS' | 'CLAVES' | 'HI_WOOD_BLOCK' | 'LOW_WOOD_BLOCK' | 'MUTE_CUICA' | 'OPEN_CUICA' | 'MUTE_TRIANGLE' | 'OPEN_TRIANGLE';

ID : [a-zA-Z_][a-zA-Z0-9_]*;

WS : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
