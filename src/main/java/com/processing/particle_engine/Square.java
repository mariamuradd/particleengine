/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: October 10th, 2024
 * Description: This class represents individual square particles. It includes methods for drawing the square, changing its size when the mouse is clicked, and changing its color to red when the 'r' key is pressed. The square reverts to its previous color when any other key is pressed afterward.
 */
package com.processing.particle_engine;

import processing.core.PApplet;

// square class that represents individual square particles with their behavior and data
public class Square extends Particle {
    private int prevColor;
    //Constructor
    Square(float x_, float y_, float radius_, Main main_, int c)
    {
       super(x_, y_, radius_, main_, c);
       this.prevColor = c;
    }

    // draws individual squares and moves them
    @Override
    public void draw(){
        main.fill(color);
        main.square(x-radius/2, y-radius/2, radius);
        main.ellipse(x-radius/2, y-radius/2, radius/2, radius/2);
        super.move();
    }
   
    // changes shape size of square when mouse clicked from increasing to decreasing
   public void changeSize(){
       if(radius>=100){
         radius-=10;
       }else{
           radius+=10;
       }
   }
   // when "r" is pressed, squares turn red but once another random key is pressed, the squares return back to the previous color
   public void colorChangeForKey(char key){
        if(key=='r'||key=='R'){
             this.color = main.color(255,0,0);
        }else{
            this.color = main.color(prevColor);
        }
   }
}
