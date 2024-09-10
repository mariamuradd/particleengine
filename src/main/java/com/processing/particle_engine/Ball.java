/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 16th, 2024
 * Description: Ball - A bouncing ball. Bounces up and down.
 */

package com.processing.particle_engine;

import processing.core.*;

public class Ball {
    PApplet main; //The main class -- provides all the functionality of processing

    float x, y; //location of the ball
    float radius; //how big the ball is
    int ballColor;

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
    }


}
