/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: October 10th, 2024
 * Description: This abstract class defines the basic properties and behaviors of a particle. It also includes methods for moving the particle, changing its direction, color, and speed, as well as an abstract method for drawing the particle, that is implemented by subclasses created.
 */
package com.processing.particle_engine;

import processing.core.PApplet;

abstract class Particle {
     Main main; // main class -- allows all functions from processing to work

    float x, y; // location of the particle
    float radius; // how big the particle is
    int color;
    float xvel = 1;
    float yvel = 1;
    int directionX = 1;
    int directionY = 1;

    // Constructor
    Particle(float x_, float y_, float radius_, Main main_, int c) {
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
            // add the sound 
            directionY *= -1; // top/bottom edge bouncing 

          main.getMelodyManager().playSpecifiMelody(4);
          if(main.getMelodyManager().isEndOfSound(4)){
              main.getMelodyManager().start(4);
          }
         
            
        }
        if (x > main.width - radius || x < radius) {
            
           
            directionX *= -1; // left/right edge bouncing
            main.getMelodyManager().playSpecifiMelody(4);
            if(main.getMelodyManager().isEndOfSound(4)){
                main.getMelodyManager().start(4);
            }
         
        }
    }

    // velocity increase function
    public void faster() {
        yvel+=2;
        xvel+=2;
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
