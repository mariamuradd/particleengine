/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: October 10th, 2024
 * Description: This class manages a collection of melodies represented by MIDI files. Allows for the playback of multiple melodies, including the ability to play specific melodies and check if a melody is done playing.
 */

package com.processing.particle_engine;

import java.util.*;

public class MelodyManager {
    ArrayList<MelodyPlayer> players;
    ArrayList<MidiFileToNotes> midiNotes;

    // Constructor
    MelodyManager() {
        players = new ArrayList<>();
        midiNotes = new ArrayList<>();
    }

    // plays all melodies by iterating over each MelodyPlayer and calling its play() method
    public void playMelodies() {
        assert (players != null);

        for (MelodyPlayer player : players) {
            player.play();
        }
    }

    // plays a specific melody by index in the players list
    public void playSpecifiMelody(int index) {
          players.get(index).play();
        // players.get(index).reset();
    }
 
    // checks if a specific melody has reached the end
    public boolean isEndOfSound(int index){
         return players.get(index).atEndOfMelody();
    }
    // adds a MIDI file and sets up its melody and rhytm for playback
    void addmidiFile(String filePath) {

        int index = players.size();
        // Change the bus to the relevant port -- if you have named it something
        // different OR you are using Windows
        players.add(new MelodyPlayer(100, "Microsoft GS Wavetable Synth")); // sets up the player with your bus.
        // player.listDevices(); //prints available midi devices to the console -- find
        // your device

        midiNotes.add(new MidiFileToNotes(filePath)); // creates a new MidiFileToNotes -- reminder -- ALL objects in
                                                      // Java
                                                      // must
                                                      // be created with "new". Note how every object is a pointer or
                                                      // reference. Every. single. one.

        int noteCount = midiNotes.get(index).getPitchArray().size(); // get the number of notes in the midi file

        // NOTE: for assert() to work, you need to change the Java extension settings to
        // run with assertions enabled
        assert (noteCount > 0); // make sure it got some notes (throw an error to alert you, the coder, if not)

        // sets the player to the melody to play the voice grabbed from the midi file
        // above
        players.get(index).setMelody(midiNotes.get(index).getPitchArray());
        players.get(index).setRhythm(midiNotes.get(index).getRhythmArray());
        players.get(index).setStartTimes(midiNotes.get(index).getStartTimeArray());
        players.get(index).reset();
    }

    // resets and starts the melody playback from the specified index
    void start(int index) {
        players.get(index).reset();
    }

}
