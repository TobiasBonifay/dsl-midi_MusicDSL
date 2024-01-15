# Music DSL Project

## Introduction

Music DSL (Domain Specific Language) is a project aimed at providing a unique way to create and manipulate musical
compositions programmatically. This project allows users to define musical pieces using a custom syntax and convert
these definitions into MIDI files for playback and further processing.

## Overview

The Music DSL project encompasses a parser for the DSL, a MIDI generator, and various utilities for handling musical
elements like notes, chords, and rhythms. The project is structured into several modules, each responsible for a
different aspect of music generation.

## Features

- **DSL for Music Composition**: Define compositions using a custom language tailored for music.
- **MIDI Generation**: Convert DSL scripts into MIDI files.
- **Support for Various Musical Elements**: Handle notes, chords, drum patterns, and more.
- **Dynamic Composition**: Alter tempo, volume, and other dynamics programmatically.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [DSL Syntax and Examples](#dsl-syntax-and-examples)
- [Modules Description](#modules-description)
- [Contributing](#contributing)

## Installation

### Prerequisites

- Java JDK 17 or higher //TODO: check if works with 11 or 14
- Maven (for building the project)
- ANTLR 4.8 (for parsing the DSL) //TODO: check version

### Steps

1. Clone the repository:
   ```shell
   git clone [repository-url]
    ```
2. Navigate to the project directory:
   ```shell
   cd music-dsl
   ```
3. Build the project:
   ```shell
    mvn clean install
    ```

## Usage

### Running the Project

To run the project, use the following command: // TODO: check music jar output

```shell 
java -jar target/music-dsl-1.0-SNAPSHOT-jar-with-dependencies.jar [path-to-dsl-script]
```

This will generate a MIDI file in the same directory as the DSL script.

### Basic Example

The following is a simple example of a DSL script that generates a MIDI file:

```text
signature 4/4
bpm 120
Instruments:
    piano ACOUSTIC_GRAND_PIANO volume 50

clip MyPiece:
bar [
    track piano:
        C4-E4-G4, C5
]

Timeline:
    MyPiece x 2
```

Run the script using the command above to generate a MIDI file named `MyPiece.mid`. //TODO: create the right hierarchie.

```
java -jar target/music-dsl-1.0-SNAPSHOT-jar-with-dependencies.jar src/main/resources/examples/basic.dsl 
```

### README Part 3: DSL Syntax and Examples

## DSL Syntax and Examples

### Syntax Overview

- The Music DSL syntax is designed to be intuitive for musicians and programmers alike. Here are the key components:
    - **Global Settings**: Define tempo, time signature, and other global aspects.
    - **Instruments Section**: Declare instruments used in the composition. (not drums)
    - **Clip and Bar Sections**: Structure your composition into clips and bars.
    - **Tracks**: Assign notes, chords, or percussion elements to specific instruments.
    - **Timeline**: Define the order of clips in the composition.

### Example Scripts

- The following are some example scripts that demonstrate the capabilities of the Music DSL.

```
// This piece features a simple intro with a piano playing chords and a drum kit on a standard 4/4 time signature at 120 BPM.
signature 4/4 
bpm 120 // set the tempo to 120 BPM. Default is 120 or 140 TODO: check
timeshift 1 // The human like error of time in ticks. A quarter note is 120 ticks on 4/4 time signature. Default is 5.
velocityrandomization 10 // The human like error of velocity. Velocity range is 0-127 depending on the dynamic of the note. Default is 5.
resolution 100 // To define the resolution to use. Default is 480 Ticks. Please use a positive integer.

Instruments: // define the instruments used in the piece. Drums should not be defined here.
    piano ACOUSTIC_GRAND_PIANO volume 50 // define the piano instrument with the ACOUSTIC_GRAND_PIANO soundfont and a volume of 50 (0-100).
    trackName VIOLIN volume 100 // define the trackName instrument with the VIOLIN soundfont and a volume of 100.

clip Intro <- ppp: // define the Intro clip with a dynamic of ppp (pianississimo) -> notes are played very softly by default.
bar [ // define the first bar of the Intro clip. Bar must be defined inside a clip.
    tempo + 100 // increase the tempo by 100 BPM.
    signature 3/4 // change the time signature to 3/4 for this bar only.

    track trackName: // a track can be empty.
        // empty 
    track piano:
        Do3-DO4-C5, Re#4, mib5 // Note can be played simultaneously by separating them with a '-' or sequentially by separating them with a ','.
]
bar [
    track trackName:
        // rest is a note that is not played. COULD be writen as 'SILENCE' | 'REST' | 'PAUSE' | 'SILENT' | 'MUTE' in any case.
        // Note CAN be defined either by their latin name (Do, Re, Mi, Fa, Sol, La, Si) or by their english name (C, D, E, F, G, A, B).
        // Octave MUST be defined after the note name.
        // Note CAN be defined with a dynamic (ppp, pp, p, mp, mf (default), f, ff, fff).
        // Note CAN'T be defined with an articulation (staccato, tenuto, accent, marcato, fermata).
        // Note CAN be defined with a duration (1/32, 1/16, 1/8, 1/4, 1/2, 1 (default), 2, 4).
        rest, G4 mf (1/2), G4 mf (1/2), G3, SILENCE 
    track piano:
        // empty
    track drums:
        LOW_TOM (1/2) LOW_TOM (1/2) COWBELL LOW_CONGA COWBELL 
        // drum patterns can be defined using the following syntax: 'DRUM_NAME (DURATION)'.
        // DURATION is optional and can be defined as a fraction (1/4, 1/2, 1 (default)). Default is one per beat.
        // BE CAREFUL: DRUM_NAME is case sensitive. No coma is needed between drum patterns.
]

clip Chorus:
bar [
    tempo - 70
    volume 90
    track trackName:
        SILENT, G4 mf, G3, SILENT
    track piano:
        do4 mf, re#4 mf, mib5 ff, REST
    track drums:
        KICK (1/2) SNARE (1/2) SNARE KICK SNARE
]

Timeline: // timeline is needed.
    Intro
    Chorus x 2 // repeat the Chorus clip twice. Be careful, space before and after 'x' is needed.

```

### README Part 4: Modules Description and Contributing

## Modules Description

### Core Modules

- **Parser**: This module uses ANTLR to parse the DSL scripts into an abstract syntax tree (AST).
- **Midi Generator**: Converts the AST into MIDI format for playback.
- **Utility Classes**: Includes classes for musical elements like notes, chords, dynamics, etc.

### Additional Modules

- **Logging and Debugging**: Facilities to log and debug the music generation process.
- **Extensions**: Supports extending the DSL for additional features.

## Contributing

### How to Contribute

- Fork the repository and create your branch from `main`.
- Make sure your code lints.
- Issue pull requests with detailed descriptions of changes.

### Reporting Bugs

- Use the issue tracker to report bugs.
- Provide as much information as possible about the bug and how to reproduce it.

### Suggesting Enhancements

- Suggestions for new features and improvements are always welcome.
- Use the issue tracker for feature requests.

---

For detailed documentation, visit [Project Documentation Link].
