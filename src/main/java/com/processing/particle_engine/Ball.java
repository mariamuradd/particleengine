/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 16th, 2024
 * Description: Bouncing balls depicted that speed up and move as user interacts with mouse/keyboard.
 */

package com.processing.particle_engine;

import processing.core.*;

//ball class that represents inidvidual partciles with their behavior and data
public class Ball extends Particle  {

    Ball(float x_, float y_, float radius_, PApplet main_, int c)
    {
        super(x_, y_, radius_, main_, c);
    }

    // draws the particle and makes it move
   public void draw()
    {
       main.fill(color);
       main.ellipse(x,y, radius, radius);
       move();
    }

    // this reverses horizontal and vertical directions
    public void changeDirection()
    {
        super.changeDirection();
       // directionX *= -1;
       // directionY *= -1;
    }
 
    // changes color to a random color
    public void changeColor()
    {
        super.changeColor();
        //color = main.color(main.random(255), main.random(255),main.random(255));
    }

    // increases horizontal and vertical velocity
    public void changeSpeed()
    {
        super.changeSpeed();
        //xvel += 0.5;
        //yvel += 0.5;
    }

}
