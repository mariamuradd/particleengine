/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 16th, 2024
 * Description: Array of ball particles created with a color coded theme.
 */

package com.processing.particle_engine;

import java.util.ArrayList;

import processing.core.PApplet;

//balls class that helps with the collection of particles
public class Balls {
    PApplet main;
    Ball ball;
    ArrayList<Ball> randomBalls;
    int unit =50; // can adjust unit size to ensure that there are at least 500 particles on the screen
    int count;

    Balls(PApplet main) {
        this.main = main;
        randomBalls = new ArrayList<>(); //initialization of the ArrayList
    }

    public void setup() {
        main.background(0); //sets background color to black
        int wideCount = main.width/unit;
        int heightCount = main.height/unit;
        System.out.println(wideCount);
        System.out.println(heightCount);
        for(int y=0;y<heightCount;y++){
            for(int x=1;x<wideCount;x++){
                  Ball sampleball = new Ball(x*unit, y*unit, 50.f, main, main.color(main.random(255), main.random(255), main.random(255)));
                  randomBalls.add(sampleball); //adds more particles to the ArrayList
            }
        }
        System.out.println(randomBalls.size());
    }

    // particles are drawn, background is cleared
    public void draw() {
        main.noStroke();
        main.background(0);
        randomBalls.forEach((ball)->{
            ball.draw();
        });
    }

    // velocity of each particle is increased when the mouse is pressed
    public void mousePressed() {
        randomBalls.forEach((ball)->{
            ball.flash();
        });
    }

    //direction of each particle is changed when the mouse is dragged
    public void mouseDragged()
    {
        randomBalls.forEach((ball)->{
            ball.changeDirection();
        });
    }

    //color of each particle changes when the mouse is moved
    public void mouseMoved()
    {
        randomBalls.forEach((ball)->{
            ball.changeColor();
        });
    }

    //this changes the speed of each particle
    public void keyPressed(){
        randomBalls.forEach((ball)->{
            ball.changeSpeed();
        });
    }
}
