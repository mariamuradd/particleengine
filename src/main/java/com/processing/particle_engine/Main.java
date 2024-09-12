/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 16th, 2024
 * Description: Particle Engine - 2nd CCIII - Create a particle engine with basic physics and some interactivity
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

    // changes background color to black
    public void setup() {
        balls.setup();
    }

    // draws everything on the screen
    public void draw() {

        balls.draw();

    }

    // handles the particles with mouse press
    public void mousePressed() {
        balls.mousePressed();
    }

    // handles particles with mouse drag and adds more interactivity
    public void mouseDragged()
    {
        balls.mouseDragged();
    }

    // handles particles with mouse move 
    public void mouseMoved()
    {
        balls.mouseMoved();
    }

    //allows the keyboard to interact with key press
    public void keyPressed()
    {
        balls.keyPressed();
    }

    //allows the particles to move in different directions when mouse clicked
    public void mouseClicked(MouseEvent event){
        balls.mouseClicked();
    }

}
