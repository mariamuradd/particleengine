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

    void draw()
    {
       main.fill(ballColor);
       main.ellipse(x,y, radius, radius);
       move();
    }

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

    void flash()
    {
        yvel++;
    }

    void changeDirection()
    {
        directionX *= -1;
        directionY *= -1;
    }

    void changeColor()
    {
        ballColor = main.color(main.random(255), main.random(255),main.random(255));
    }

    void changeSpeed()
    {
        xvel += 0.5;
        yvel += 0.5;
    }

}
