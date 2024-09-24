/* 
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 23rd, 2024
 * Description: This class represents individual ball particles. It includes methods for drawing the ball, changing its direction, color, and speed, as well as handling collisions with other balls and implementing additional interactions such as scattering on mouse click.
 */
package com.processing.particle_engine;

import processing.core.*;

//ball class that represents individual ball particles with their behavior and data
public class Ball extends Particle  {

    //Constructor
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
    }
 
    // changes color to a random color
    public void changeColor()
    {
        super.changeColor();
    }

    // increases horizontal and vertical velocity
    public void changeSpeed()
    {
        super.changeSpeed();
    }

    // extra credit :)
    public void scatterTo(float clickX, float clickY){
        float dx = x - clickX;
        float dy = y - clickY;
        float distance = PApplet.dist(x, y, clickX, clickY);
        if (distance < 100){
            xvel = dx / distance * 5;
            yvel = dy / distance * 5;
        }
    }

    // when two balls collide with each other, they move away from each other
    public void checkCollision(Ball other) {
        float dx = other.x - this.x;
        float dy = other.y - this.y;
        float distance = PApplet.sqrt(dx * dx + dy * dy);
        float minDist = (this.radius / 2) + (other.radius / 2);
 
        // Check if balls are colliding
        if (distance < minDist) {
            float angle = PApplet.atan2(dy, dx); // angle of collision
 
            // resolve collision by adjusting velocities based on mass (use of radius as mass here :))
            float targetX = this.x + PApplet.cos(angle) * minDist;
            float targetY = this.y + PApplet.sin(angle) * minDist;
            float ax = (targetX - other.x) * 0.05f;
            float ay = (targetY - other.y) * 0.05f;
 
            // apply the forces to both balls
            this.xvel -= ax;
            this.yvel-= ay;
            other.xvel += ax;
            other.yvel += ay;
        }
    }

}
