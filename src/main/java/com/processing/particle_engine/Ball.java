/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 16th, 2024
 * Description: Bouncing balls depicted that speed up as user interacts with mouse/keyboard.
 */

package com.processing.particle_engine;

import processing.core.*;

//ball class that represents inidvidual partciles with their behavior and data
public class Ball {
    PApplet main; //The main class -- provides all the functionality of processing

    float x, y; //location of the ball
    float radius; //how big the ball is
    int ballColor;
    float yvel=1;
    float xvel=1;
    //int direction =1;
    int directionX =1;
    int directionY =1;

    Ball(float x_, float y_, float radius_, PApplet main_, int c)
    {
        x = x_;
        y = y_;
        radius = radius_;
        ballColor = c;
        main = main_;
    }

    // draws the particle and makes it move
    void draw()
    {
       main.fill(ballColor);
       main.ellipse(x,y, radius, radius);
       move();
    }

    //this setup helps balls bounce off the top/bottom & left/right edges
    void move()
    {
        x += xvel * directionX;
        y += yvel * directionY;

        if (y > main.height - radius || y < radius) {
            directionY *= -1;
        }
        if (x > main.width - radius || x < radius) {
            directionX *= -1;
        }
       // y+=yvel*direction;
       // if(y>main.height){
       //     direction=-1;
       // }
       // if(y<0){
       //     direction=1;
       // }
    }

    // increases vertical velocity
    void flash()
    {
        yvel++;
    }

    // this reverses horizontal and vertical directions
    void changeDirection()
    {
        directionX *= -1;
        directionY *= -1;
    }

    // changes color to a random color
    void changeColor()
    {
        ballColor = main.color(main.random(255), main.random(255),main.random(255));
    }

    // increases horizontal and vertical velocity
    void changeSpeed()
    {
        xvel += 0.5;
        yvel += 0.5;
    }

}
