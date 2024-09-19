package com.processing.particle_engine;

import processing.core.PApplet;
import processing.core.PConstants;

//triangle class that represents individual triangle particles with their behavior and data
public class Triangle extends Particle {
    float angle = 0;

    //Constructor
    Triangle(float x_, float y_, float radius_, PApplet main_, int c) {

        super(x_, y_, radius_, main_, c);
        this.angle = 0;
    }

    // draws individual triangles and rotates them
    public void draw() {
        main.fill(color);
        main.pushMatrix();
        main.translate(x, y);
        main.rotate(angle);
        main.beginShape();
        main.vertex(-radius / 2, radius / 2);
        main.vertex(radius / 2, radius / 2);
        main.vertex(0, -radius / 2);
        main.endShape(PConstants.CLOSE);

        main.popMatrix();
        super.move();
    }

   
    // change color of triangles
    public void changeColor() {
        super.changeColor();
    }

    // when mouse is clicked, the triangles go in the opposite direction of the balls and squares
    public void changeTriangleDirection() {
        super.changeDirection();
    }

    // triangle rotates when any key is pressed
    public void changeRotate() {
        this.angle += PApplet.radians(45);
    }

}
