package com.processing.particle_engine;

import java.util.ArrayList;

import processing.core.PApplet;

public class Balls {
    PApplet main;
    Ball ball;
    ArrayList<Ball> randomBalls;

    Balls(PApplet main) {
        this.main = main;
        randomBalls = new ArrayList<>();
    }

    public void setup() {
        main.background(0);
        ball = new Ball(main.width / 2.0f, main.height * .10f, 50.f, main,
                main.color(main.random(255), main.random(255), main.random(255)));
    }

    public void draw() {
        main.noStroke();
        main.background(0);
        ball.draw();
    }

    public void mousePressed() {
        ball.flash();
    }
}
