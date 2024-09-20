/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 23rd, 2024
 * Description: Particle Engine Part 2 - CCIII: Creates a particle engine with different shapes and different mouse/key interactions for each particle!
 */
package com.processing.particle_engine;

import processing.core.*;
import processing.event.MouseEvent;

// main class to integrate processing and handle user interactions
public class Main extends PApplet {

    Balls balls; // a ball that we will draw to the screen

    // sets up processing
    public static void main(String[] args) {
        PApplet.main("com.processing.particle_engine.Main");
    }

    // sets up the size of the window
    public void settings() {

        size(1500, 1500);
        balls = new Balls(this);
    }

    // sets up project
    public void setup() {
        balls.setup();
    }

    // draws everything on the screen
    public void draw() {
        balls.draw();
    }

    // handles the particles with mouse press
    public void mousePressed() {
        balls.mousePressed(mouseX, mouseY);
    }

    // allows the keyboard to interact with key press
    public void keyPressed() {
        balls.keyPressed();
    }

    // allows the particles to move in different directions when mouse clicked
    public void mouseClicked(MouseEvent event) {
        balls.mouseClicked();
    }

}
