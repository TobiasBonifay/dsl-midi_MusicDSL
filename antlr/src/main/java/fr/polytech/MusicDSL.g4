grammar MusicDSL;

// Parser Rules
musicComposition : globalSettings instrumentsSection clipSection mainSection;

globalSettings : signature? bpm? volume? velocity?;

signature : 'signature' FRACTION;
bpm : 'bpm' INT;
volume : 'volume' INT;
velocity : 'velocity' VELOCITY_SYMBOL;
// TODO : add patch

// ----------------- INSTRUMENT -----------------
instrumentsSection : 'Instruments:' instrumentDefinition+;
instrumentDefinition : INSTRUMENT 'volume' INT;

// ----------------- CLIP -----------------
clipSection : 'clip' clip+;
clip : CLIP_NAME ':' barSequence;

// ----------------- BAR -----------------
barSequence : 'bar' '[' barContent ']';
barContent : tempoChange? volumeSetting? velocitySetting? trackSequence;

// ----------------- TRACK -----------------
tempoChange : 'LINEAR|' 'tempo' SIGNED_INT;
volumeSetting : 'volume' INT;
velocitySetting : VELOCITY_SYMBOL;

trackSequence : track+;
track : 'track' INSTRUMENT trackContent;
trackContent : (noteSequence | percussionElement)+;

// ----------------- NOTE -----------------
noteSequence : note (',' note)*;
note : NOTE velocitySetting? duration?;

duration : '(' FRACTION ')';

percussionElement : PERCUSSION '|' NOTE;

mainSection : MAIN_SEQUENCE;

// Lexer Rules
FRACTION : INT '/' INT;
SIGNED_INT : '-'? INT;
INT : [0-9]+; // TODO : Fix digit grammar

VELOCITY_SYMBOL : 'ppp' | 'pp' | 'p' | 'mp' | 'm' | 'mf' | 'f' | 'ff' | 'fff'
                 | '---' | '--' | '-' | 'x' | '+' | '++' | '+++' | 'default';

INSTRUMENT : 'PIANO' | 'HARP' | 'VIOLIN' | 'CELLO' | 'FLUTE' | 'TRUMPET' | 'SAXOPHONE' | 'GUITAR' | 'BASS' | 'DRUMS';

NOTE : [A-G] ( '#' | 'b' )? [0-9];

PERCUSSION : 'BASS_DRUM' | 'SNARE_DRUM' | 'CLOSED_HI_HAT' | 'OPEN_HI_HAT' | 'CRASH_CYMBAL' | 'RIDE_CYMBAL'
            | 'TAMBOURINE' | 'COWBELL' | 'CLAP' | 'MARACAS' | 'HIGH_BONGO' | 'LOW_BONGO' | 'MUTE_HIGH_CONGA'
            | 'OPEN_HIGH_CONGA' | 'LOW_CONGA' | 'HIGH_TIMBALE' | 'LOW_TIMBALE' | 'HIGH_AGOGO' | 'LOW_AGOGO'
            | 'CABASA' | 'SHORT_WHISTLE' | 'LONG_WHISTLE' | 'SHORT_GUIRO' | 'LONG_GUIRO' | 'CLAVES'
            | 'HIGH_WOOD_BLOCK' | 'LOW_WOOD_BLOCK' | 'MUTE_CUICA' | 'OPEN_CUICA' | 'MUTE_TRIANGLE' | 'OPEN_TRIANGLE';

CLIP_NAME : [A-Z][A-Z0-9-]*;

MAIN_SEQUENCE : 'CHORUS x2 COUPLET-A CHORUS'; // TODO : handle ALL SEQUENCES

WS : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
