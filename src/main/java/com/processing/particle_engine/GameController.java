package com.processing.particle_engine;

import processing.core.PApplet;

public abstract class GameController {

    PApplet main;
    //Constructor
    GameController(PApplet main_){
    main = main_;
    } 
    public abstract void draw();
}

