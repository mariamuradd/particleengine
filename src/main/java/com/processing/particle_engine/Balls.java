/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 16th, 2024
 * Description: Array of ball particles created with a color coded theme. There is a lot of interactivity with mouse Click/Drag/Pressed and keyboard.
 */

package com.processing.particle_engine;

import java.util.ArrayList;

import processing.core.PApplet;

//balls class that helps with the collection of particles
public class Balls {
    PApplet main;
    ArrayList<Ball> balls;
    ArrayList<Square> squares;
    ArrayList<Triangle> triangles;
    int unit = 50; // can adjust unit size to ensure that there are at least 500 particles on the
                   // screen
    int count;

    Balls(PApplet main) {
        this.main = main;
        balls = new ArrayList<>(); // initialization of the ArrayList
        squares = new ArrayList<>();
        triangles = new ArrayList<>();
    }

    public void setup() {
        main.background(0); // sets background color to black
        int wideCount = main.width / unit;
        int heightCount = main.height / unit;
        System.out.println(wideCount);
        System.out.println(heightCount);
        float noOfballs = main.random(21, 35);
        for (int i = 0; i < noOfballs; i++) {

            Ball sampleBall = new Ball(main.random(main.width), main.random(main.height), 50.f, main,
                    main.color(main.random(255), main.random(255), main.random(255)));
            Triangle triangle1 = new Triangle(main.random(main.width), main.random(main.height), 50.f, main,
            main.color(main.random(255), main.random(255), main.random(255)));
            Square square1 = new Square(main.random(main.width), main.random(main.height), 50.f, main,
            main.color(main.random(255), main.random(255), main.random(255))) ;    
            squares.add(square1);
            triangles.add(triangle1);   
            balls.add(sampleBall);
        }
        System.out.println(balls.size());
    }

    // particles are drawn, background is cleared
    public void draw() {
        main.noStroke();
        main.background(0);
        balls.forEach((particle) -> {
            particle.draw();
        });
        triangles.forEach((triangle)->{
            triangle.draw();
        });
        squares.forEach((squares)->{
            squares.draw();
        });
    }

    // velocity of each particle is increased when the mouse is pressed
    public void mousePressed() {
        balls.forEach((particle) -> {
            particle.flash();
        });

    }

    // direction of each particle is changed when the mouse is dragged
    public void mouseDragged() {
        balls.forEach((particle) -> {
            particle.changeDirection();
        });
    }

    // color of each particle changes when the mouse is moved
    public void mouseMoved() {
        balls.forEach((particle) -> {
            particle.changeColor();
        });
        
    }

    // this changes the speed of each particle when key is pressed
    public void keyPressed() {
        balls.forEach((particle) -> {
            particle.changeSpeed();
        });

        triangles.forEach((particle)->{
            particle.changeSpeed();
        });

        squares.forEach((particle)->{
            particle.changeSpeed();
        });
    }

    //three different actions for the three different particles when mouse is clicked
    public void mouseClicked() {
        balls.forEach((particle) -> {
            particle.changeColor();
        });
        squares.forEach((particle)->{
            particle.changeSize();
        });
        triangles.forEach((particle)->{
             particle.changeRotate();
        });
    }
    
}
