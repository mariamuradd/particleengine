package com.processing.particle_engine;

import java.util.ArrayList;

import processing.core.PApplet;

public class Balls {
    PApplet main;
    Ball ball;
    ArrayList<Ball> randomBalls;
    int unit =50;
    int count;

    Balls(PApplet main) {
        this.main = main;
        randomBalls = new ArrayList<>();
    }

    public void setup() {
        main.background(0);
        int wideCount = main.width/unit;
        int heightCount = main.height/unit;
        System.out.println(wideCount);
        System.out.println(heightCount);
        for(int y=0;y<heightCount;y++){
            for(int x=1;x<wideCount;x++){
                  Ball sampleball = new Ball(x*unit, y*unit, 50.f, main, main.color(main.random(255), main.random(255), main.random(255)));
                  randomBalls.add(sampleball);
            }
        }
        System.out.println(randomBalls.size());
        // ball = new Ball(main.width / 2.0f, main.height * .10f, 50.f, main,
        //         main.color(main.random(255), main.random(255), main.random(255)));
    }

    public void draw() {
        main.noStroke();
        main.background(0);
       // ball.draw();
        randomBalls.forEach((ball)->{
            ball.draw();
        });
    }

    public void mousePressed() {
        randomBalls.forEach((ball)->{
            ball.flash();
        });
    }

    public void mouseDragged()
    {
        randomBalls.forEach((ball)->{
            ball.changeDirection();
        });
    }

    public void mouseMoved()
    {
        randomBalls.forEach((ball)->{
            ball.changeColor();
        });
    }

    public void keyPressed(){
        randomBalls.forEach((ball)->{
            ball.changeSpeed();
        });
    }
}
