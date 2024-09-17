package com.processing.particle_engine;

import processing.core.PApplet;

public abstract class Particle {
     PApplet main; // main class -- allows all functions from processing to work

    float x, y; // location of the particle
    float radius; // how big the particle is
    int color;
    float xvel = 1;
    float yvel = 1;
    int directionX = 1;
    int directionY = 1;

    // Constructor
    Particle(float x_, float y_, float radius_, PApplet main_, int c) {
        x = x_;
        y = y_;
        radius = radius_;
        color = c;
        main = main_;
    }

    // use of abstract method so to be used by subclasses
    public abstract void draw();

    // moves the particle
    public void move() {
        x += xvel * directionX;
        y += yvel * directionY;

        if (y > main.height - radius || y < radius) {
            directionY *= -1; // top/bottom edge bouncing 
        }
        if (x > main.width - radius || x < radius) {
            directionX *= -1; // left/right edge bouncing
        }
    }

    // vertical velocity increase function
    public void flash() {
        yvel++;
    }

    // direction change of the particle
    public void changeDirection() {
        directionX *= -1;
        directionY *= -1;
    }

    // color change of the particle
    public void changeColor() {
        color = main.color(main.random(255), main.random(255), main.random(255));
    }

    // speed change of the particle
    public void changeSpeed() {
        xvel += 0.5;
        yvel += 0.5;
    }
}
