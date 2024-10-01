/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 30th, 2024
 * Description: Particle Engine Part 2 - CCIII: Creates a particle engine with different shapes and different mouse/key interactions for each particle!
 */
package com.processing.particle_engine;

import java.util.ArrayList;

import processing.core.*;
import processing.event.MouseEvent;

// main class to integrate processing and handle user interactions
public class Main extends PApplet {

    // GameStarted balls; // a ball that we will draw to the screen
    ArrayList<GameController> gameControllers;
    int curState=0;

    // sets up processing
    public static void main(String[] args) {
        PApplet.main("com.processing.particle_engine.Main");
    }

    // sets up the size of the window
    public void settings() {

        size(1500, 1500);
        gameControllers = new ArrayList<>();
        gameControllers.add(new GameBegin(this));
        gameControllers.add(new GameStarted(this));
        gameControllers.add(new GameEnded(this));
    }

    // sets up project
    public void setup() {
        gameControllers.forEach((item)->{
            item.setup();
        });
    }

    // draws everything on the screen
    public void draw() {
        gameControllers.get(curState).draw();
        curState = gameControllers.get(curState).getCurState();
        gameControllers.get(curState).setCurState(curState);
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

}
