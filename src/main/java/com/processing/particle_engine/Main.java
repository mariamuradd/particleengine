/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: October 10th, 2024
 * Description: This class creates a particle engine with different shapes and different mouse/key interactions for each particle. It manages the main game loop, user interactions, and melody playback using the MelodyManager class. The game has 3 states each controlled by different game controllers within an ArrayList.
 */
package com.processing.particle_engine;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.ArrayList;

import processing.core.*;
import processing.event.MouseEvent;

// main class to integrate processing and handle user interactions
public class Main extends PApplet {

    static FileSystem sys = FileSystems.getDefault();
    // GameStarted balls; // a ball that we will draw to the screen
    ArrayList<GameController> gameControllers;
    int curState = 0;
    static String filePath = "mid" + sys.getSeparator();

    // array of different MIDI file names for background music
    String[] midiFiles = { "Electric_Bass","Piano","Trumpet","pipe organ","Xylophone","Violoncello"};

    MelodyManager melodyManager = new MelodyManager();

    // sets up processing
    public static void main(String[] args) {
        PApplet.main("com.processing.particle_engine.Main");
    }

    // sets up the size of the window and initializes game states
    public void settings() {

        size(1500, 1500);
        gameControllers = new ArrayList<>();
        gameControllers.add(new GameBegin(this));
        gameControllers.add(new GameStarted(this));
        gameControllers.add(new GameEnded(this));
        melodyManager.addmidiFile(filePath);
    }

    // sets up project, including game controllers and MIDI files
    public void setup() {
        gameControllers.forEach((item) -> {
            item.setup();
        });
        addMidiFiles();
        for (int i = 0; i < midiFiles.length; i++) {
            melodyManager.start(i);
        }
    }

    // draws everything on the screen
    public void draw() {
        gameControllers.get(curState).draw();
        curState = gameControllers.get(curState).getCurState();
        gameControllers.get(curState).setCurState(curState);
    
    }

    // adds MIDI files to the melody manager for playback
    public void addMidiFiles() {
        for (int i = 0; i < midiFiles.length; i++) {
            melodyManager.addmidiFile(filePath + midiFiles[i] + ".mid");
        }
    }

    // handles the particles with mouse press
    public void mousePressed() {
        gameControllers.get(curState).mousePressed(mouseX, mouseY);

    }

    // allows the keyboard to interact with key press
    public void keyPressed() {
        gameControllers.get(curState).keyPressed();
    }

    // allows the particles to move in different directions when mouse clicked
    public void mouseClicked(MouseEvent event) {
        gameControllers.get(curState).mouseClicked();
    }

    // provide access in Melody manager for managing background music
    public MelodyManager getMelodyManager()
    {
        return melodyManager;
    }

}
