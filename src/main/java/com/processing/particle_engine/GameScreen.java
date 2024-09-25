package com.processing.particle_engine;

import processing.core.PApplet;

public class GameScreen {
    PApplet main;
    int screenWidth = 1500;
    int screenHeight = 1500;

    GameScreen(PApplet main_) { // constructor
        main = main_;
    }

    // start game screen
    void displayTitleScreen() {
        main.background(50, 50, 150);

        // Draw title text
        main.fill(255);
        main.textSize(64);
        // int screenWidth;
        // int screenHeight;
        main.text("Triangle Eater", 550, 300);

        // Draw Start Button
        // Draw Start Button
        main.fill(0, 200, 0);
        float buttonX = screenWidth / 2 - 100;
        float buttonY = screenHeight / 2;
        float buttonWidth = 200;
        float buttonHeight = 60;

        main.rect(buttonX, buttonY, buttonWidth, buttonHeight);

        // Draw Start Button Text
        main.fill(255);
        main.textSize(32);
        main.text("Start", screenWidth / 2-30, buttonY + buttonHeight / 2+10);
    }

// end game screen
void displayEndScreen(int score) {
    main.background(50, 50, 150);  // background color 
 
    // Draw "Game Over" text
    main.fill(255);
    main.textSize(64);
    main.text("Game Over", screenWidth / 2 - 200, 300);  // center the text
 
    // display the final score
    main.textSize(48);
    main.text("Your Score: " + score, screenWidth / 2 - 200, 400);
 
    // draw Restart button
    main.fill(0, 200, 0);
    float buttonX = screenWidth / 2 - 100;
    float buttonY = screenHeight / 2;
    float buttonWidth = 200;
    float buttonHeight = 60;
    main.rect(buttonX, buttonY, buttonWidth, buttonHeight);
 
    // draw Restart Button text
    main.fill(255);
    main.textSize(32);
    main.text("Restart", screenWidth / 2 - 50, buttonY + buttonHeight / 2 + 10);
}

}
