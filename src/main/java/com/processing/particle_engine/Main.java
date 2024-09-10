/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 16th, 2024
 * Description: Particle Engine - 2nd CCIII - Create a particle engine with basic physics and some interactivity
 */
package com.processing.particle_engine;

import processing.core.*;

public class Main extends PApplet {

    Ball ball; //a ball that we will draw to the screen

    //sets up processing and prints the hello world message to the console
    public static void main(String[] args) {
        PApplet.main("com.processing.particle_engine.Main");
    }

    //sets up the size of the window
    public void settings() {
    
        size(500, 500);
    }

    // changes background color to black
    public void setup() {
        background(0);
        ball = new Ball(width/2.0f, height*.10f, 50.f, this, color(random(255), random(255), random(255)));
    }

    //draws everything on the screen
    public void draw() {

        noStroke();
        ball.draw();


    }

    // will be doing something with particles
    public void mousePressed()
    {

    }
}

