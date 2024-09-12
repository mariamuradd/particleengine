/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 16th, 2024
 * Description: Particle Engine - 2nd CCIII - Create a particle engine with basic physics and some interactivity
 */
package com.processing.particle_engine;

import processing.core.*;

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

    // will be doing something with particles
    public void mousePressed() {
        balls.mousePressed();
    }

    // more mouse interactions
    public void mouseDragged()
    {
        balls.mouseDragged();
    }

    public void mouseMoved()
    {
        balls.mouseMoved();
    }

    //allows the keyboard to interact
    public void keyPressed()
    {
        balls.keyPressed();
    }

}
