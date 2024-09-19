package com.processing.particle_engine;

import processing.core.PApplet;

public class Triangle extends Particle {
    float angle =0;
   Triangle(float x_, float y_, float radius_, PApplet main_, int c) {
    
    super(x_, y_, radius_, main_, c);
    main.rotate(angle);
    //super.main.translate(x_, y_);
   }

   public void draw(){
    main.fill(color);
    
    main.triangle(x,y,x+100,y+100,x,y+100);
    super.move();
   }

   public void changeDirection(){
    super.changeDirection();
   }

   public void changeColor(){
    super.changeColor();
   }

   //when mouse is clicked, the triangles go in the opposite direction of the balls and squares
   public void changeRotate(){
      super.changeDirection();
   }

   public void changeSpeed(){
    super.changeSpeed();
   }
}


