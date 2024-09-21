/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 23rd, 2024
 * Description: This class manages a collection of particles including balls, squares, and triangles. It initializes the particles, handles their drawing, and implements various interactions such as mouse and key events to modify particle behavior.
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

    // sets up all three particles
    public void setup() {
        main.background(0); // sets background color to black;
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

        // collision for balls
        for (int i = 0; i < balls.size(); i++) {
            for (int j = i + 1; j < balls.size(); j++) {
                balls.get(i).checkCollision(balls.get(j));
            }
        }
    }

    // extra credit
    public void mousePressed(float clickX, float clickY)
    {
        for(Ball ball : balls){
            ball.faster();
            ball.scatterTo(clickX, clickY);
        }
    }

    // balls: changes the speed when key is pressed / triangles: rotation when key is pressed / squares: change to red when r is pressed
    public void keyPressed() {
        balls.forEach((particle) -> {
            particle.changeSpeed();
        });

        triangles.forEach((particle)->{
            particle.changeRotate();
        });

        squares.forEach((particle)->{
            particle.colorChangeForKey(main.key);
        });
    }

    //balls: when mouse is clicked, balls change colors / squares: when mouse clicked, squares decrease and increase / triangles: when mouse clicked, change directions.
    public void mouseClicked() {
        balls.forEach((particle) -> {
            particle.changeColor();
        });
        squares.forEach((particle)->{
            particle.changeSize();
        });
        triangles.forEach((particle)->{
             particle.changeTriangleDirection();
        });
    }
    
}
