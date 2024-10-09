/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 30th, 2024
 * Description: This class represents individual triangle particles. It includes methods for drawing the triangle, changing its color, direction, and rotation. The triangle also rotates when any key is pressed and changes direction when the mouse is clicked.
 */
package com.processing.particle_engine;

import processing.core.PApplet;
import processing.core.PConstants;

//triangle class that represents individual triangle particles with their behavior and data
public class Triangle extends Particle {
    private float angle = 0;
    public boolean isVisible;

    // Constructor
    Triangle(float x_, float y_, float radius_, Main main_, int c) {

        super(x_, y_, radius_, main_, c);
        this.angle = 0;
        isVisible = true;
    }

    // draws individual triangles and rotates them
    @Override
    public void draw() {
        if(isVisible){
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
    }

    // change color of triangles
    public void changeColor() {
        super.changeColor();
    }

    // when mouse is clicked, the triangles go in the opposite direction of the
    // balls and squares
    public void changeTriangleDirection() {
        super.changeDirection();
    }

    // triangle rotates when any key is pressed
    public void changeRotate() {
        this.angle += PApplet.radians(45);
    }

    // Method to check if a point (mouseX, mouseY) is inside the triangle
    public boolean isClicked(float mouseX, float mouseY) {
        // calculate the triangle's sides based on its position and radius
        float x1 = x + radius * PApplet.cos(angle); // First vertex
        float y1 = y + radius * PApplet.sin(angle);
        float x2 = x + radius * PApplet.cos(angle + PConstants.TWO_PI / 3); // Second vertex
        float y2 = y + radius * PApplet.sin(angle + PConstants.TWO_PI / 3);
        float x3 = x + radius * PApplet.cos(angle + 2 * PConstants.TWO_PI / 3); // Third vertex
        float y3 = y + radius * PApplet.sin(angle + 2 * PConstants.TWO_PI / 3);
        // Check if the point (mouseX, mouseY) is inside the triangle using a
        // point-in-triangle test   
        if(isPointInTriangle(mouseX, mouseY, x1, y1, x2, y2, x3, y3)){
            isVisible = false;
        }
        return isPointInTriangle(mouseX, mouseY, x1, y1, x2, y2, x3, y3);
    }

    // Helper method to check if a point (px, py) is inside a triangle formed by
    // (x1, y1), (x2, y2), (x3, y3)
    private boolean isPointInTriangle(float px, float py, float x1, float y1, float x2, float y2, float x3, float y3) {
        float d1 = sign(px, py, x1, y1, x2, y2);
        float d2 = sign(px, py, x2, y2, x3, y3);
        float d3 = sign(px, py, x3, y3, x1, y1);
        boolean hasNeg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        boolean hasPos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(hasNeg && hasPos); // The point is inside if all signs are either positive or negative
    }

    // Helper method to calculate the determinant of vectors (px, py) -> (x1, y1)
    // and (x1, y1) -> (x2, y2)
    private float sign(float px, float py, float x1, float y1, float x2, float y2) {
        return (px - x2) * (y1 - y2) - (x1 - x2) * (py - y2);
    }

}
