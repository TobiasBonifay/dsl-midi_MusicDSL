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
                 | '---' | '--' | '-' | 'x' | '+' | '++' | '+++';
INSTRUMENT : 'VIOLIN' | 'PIANO' | 'DRUMS'; // TODO : add more instruments: https://en.wikipedia.org/wiki/General_MIDI#Program_change_events
NOTE : [A-G] '#'? [0-8]; // TODO : check notes (https://en.wikipedia.org/wiki/Scientific_pitch_notation)
    // TODO : add flat notes
PERCUSSION : 'KICK' | 'HIGH-HAT'; // TODO : add more percussions (https://en.wikipedia.org/wiki/General_MIDI#Percussion)
CLIP_NAME : 'CHORUS' | 'COUPLET-A'; // TODO : handle ALL CLIP NAMES
MAIN_SEQUENCE : 'CHORUS x2 COUPLET-A CHORUS'; // TODO : handle ALL SEQUENCES
WS : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;


