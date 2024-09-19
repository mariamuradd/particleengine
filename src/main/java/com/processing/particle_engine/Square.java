package com.processing.particle_engine;

import processing.core.PApplet;

public class Square extends Particle {
    Square(float x_, float y_, float radius_, PApplet main_, int c)
    {
       super(x_, y_, radius_, main_, c);
    }

    public void draw(){
        main.fill(color);
        //main.rect(x - radius / 2, y - radius / 2, radius, radius);
        main.square(x-radius/2, y-radius/2, radius);
        super.move();
    }

    public void changeDirection(){
        super.changeDirection();
    }

    public void changeColor(){
        super.changeColor();

    }

    public void changeSpeed(){
        super.changeSpeed();
    }
   
    // changes shape size of square when mouse clicked from increasing to decreasing
   public void changeSize(){
       if(radius>=100){
         radius-=10;
       }else{
           radius+=10;
       }
   }
}
