grammar MusicDSL;

// Parser rules
composition: (signature | bpm | velocity | volume | instruments | bar)*;

signature: 'signature' FRACTION;
bpm: 'bpm' INT;
velocity: 'velocity' VELOCITY;
volume: 'volume' INT;
instruments: 'Instruments:' instrument+;
instrument: INSTRUMENT 'volume' INT;
bar: 'bar' '[' (tempo? volumeSetting? velocitySetting? track)* ']' 'repeat' 'x' INT ';';

tempo: 'LINEAR|' 'tempo' SIGNED_INT;
volumeSetting: 'volume' INT ('1-100' '€' 'N' '(' '%'))?;
velocitySetting: VELOCITY;

track: 'track' INSTRUMENT velocitySetting? note+;
note: NOTE velocitySetting? '(' FRACTION ')' (',' | '//')?;

// Lexer rules
FRACTION: INT '/' INT;
SIGNED_INT: '-'? INT;
INT: [0-9]+;
VELOCITY: 'ppp' | 'pp' | 'p' | 'mp' | 'm' | 'mf' | 'f' | 'ff' | 'fff' | '---' | '--' | '-' | 'x' | '+' | '++' | '+++';
INSTRUMENT: 'VIOLIN' | 'PIANO' | 'DRUMS' | 'KICK' | 'HIGH-HAT';
NOTE: [A-G] '#'? [0-8];
WS: [ \t\r\n]+ -> skip;
