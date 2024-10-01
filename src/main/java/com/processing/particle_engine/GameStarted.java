/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 30th, 2024
 * Description: This class manages a collection of particles including balls, squares, and triangles. It initializes the particles, handles their drawing, and implements various interactions such as mouse and key events to modify particle behavior.
 */
package com.processing.particle_engine;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;

//GameStarted class that helps game state when running and manages interactions of particle
public class GameStarted  extends GameController{
    private ArrayList<Ball> balls;
    private ArrayList<Square> squares;
    private ArrayList<Triangle> triangles;
    private ArrayList<Particle> gameObjects;
    private GameScreen gs;
    private int count;
    private ArrayList<Integer> countList ;
    private int MaxCount;
    int screenWidth = 1500;
    int screenHeight = 1500;
    int startTime;
    int elapsedTime;

    //Constructor
    GameStarted(PApplet main) {
        super(main);
        balls = new ArrayList<>(); // initialization of the ArrayList
        squares = new ArrayList<>();
        triangles = new ArrayList<>();
        gs = new GameScreen(main);
        count = 0;
        startTime = main.millis();
        countList = new ArrayList<>();
    }

    // sets up all three particles and initializes them with random properties
    public void setup() {
        main.background(0); // sets background color to black;
        float noOfballs = main.random(21, 35);
        for (int i = 0; i < noOfballs; i++) {

            Ball sampleBall = new Ball(main.random(main.width), main.random(main.height), 50.f, main,
                    main.color(main.random(255), main.random(255), main.random(255)));
            Triangle triangle1 = new Triangle(main.random(main.width), main.random(main.height), 50.f, main,
                    main.color(main.random(255), main.random(255), main.random(255)));
            Square square1 = new Square(main.random(main.width), main.random(main.height), 50.f, main,
                    main.color(main.random(255), main.random(255), main.random(255)));
            squares.add(square1);
            triangles.add(triangle1);
            balls.add(sampleBall);
        }
        gameObjects = new ArrayList<>();
        gameObjects.addAll(squares);
        gameObjects.addAll(triangles);
        gameObjects.addAll(balls);
    }

    // particles are drawn, background is cleared
    public void draw() {
        main.noStroke();
        main.background(0);
       
        gameObjects.forEach((particle) -> { // polymorphism - instead of using 3 different for loops, I used 1 with
            // method overriding.
            particle.draw();
        });
        timer();
        // collision for balls
        for (int i = 0; i < balls.size(); i++) {
            for (int j = i + 1; j < balls.size(); j++) {
                balls.get(i).checkCollision(balls.get(j));
            }
        }

        // when timer hits 60 seconds, end game screen appears
        if (this.elapsedTime >= 60) {
            // gameStart = false;
            gameEndMech();
            count=0;
        }else{
             setCurState(GAME_PLAY);
        }
    }

    // resets timer, score saved, switch state
    public void gameEndMech() {
        elapsedTime = 0;
        startTime = main.millis();
        addScore(count);
        MaxCount = Math.max(count, MaxCount);
        setCurState(GAME_END);
    }

    // calculates and displays elapsed time in seconds
    public void timer() {
        int currentTime = main.millis(); // Get the current time in milliseconds
        this.elapsedTime = (currentTime - startTime) / 1000; // Convert to seconds
        main.textAlign(PConstants.RIGHT, PConstants.TOP); // Align text to the right and top
        main.textSize(24);
        main.fill(255);
        main.text("Timer: " + elapsedTime + "s", screenWidth - 20, 20); // Display the timer
        main.textAlign(PConstants.CENTER, PConstants.CENTER); // Reset text alignment
    }

    // extra credit - check if triangle is clicked, increase score
    public void mousePressed(float clickX, float clickY) {
        //
       
    
            for (Ball ball : balls) {
                ball.scatterTo(clickX, clickY);
            }

            for (Triangle triangle : triangles) {
                if (triangle.isVisible) {
                    if (triangle.isClicked(main.mouseX, main.mouseY)) {
                        count++;
                    }
                }
            }
            gameObjects.addAll(triangles);
        
    }

    // balls: changes the speed when key is pressed / triangles: rotation when key
    // is pressed / squares: change to red when r is pressed
    public void keyPressed() {
        balls.forEach((particle) -> {
            particle.changeSpeed();
        });

        triangles.forEach((particle) -> {
            particle.changeRotate();
        });

        squares.forEach((particle) -> {
            particle.colorChangeForKey(main.key);
        });
    }

    // balls: when mouse is clicked, balls change colors / squares: when mouse
    // clicked, squares decrease and increase / triangles: when mouse clicked,
    // change directions.
    public void mouseClicked() {
        balls.forEach((particle) -> {
            particle.changeColor();
        });
        squares.forEach((particle) -> {
            particle.changeSize();
        });
        triangles.forEach((particle) -> {
            particle.changeTriangleDirection();
        });
    }

    

}
