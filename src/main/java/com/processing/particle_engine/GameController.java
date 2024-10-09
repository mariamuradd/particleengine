/*
 * Name: Maria Murad
 * Project Name: "Particle Engine"
 * Date: September 30th, 2024
 * Description: This abstract class defines the general structure for controlling the different game states. Provides methods to handle game transitions and manages scores of Triangle Eater game.
 */
package com.processing.particle_engine;

import java.util.ArrayList;

import processing.core.PApplet;

public abstract class GameController {

    Main main;
    static final int GAME_BEGIN=0;
    static final int GAME_PLAY=1;
    static final int GAME_END=2;
    static ArrayList<Integer> scores = new ArrayList<>();
    int curState;
    MelodyManager melodies = null;

    // Constructor
    GameController(Main main_) {
        main = main_;
        melodies= main_.getMelodyManager();
    }

    // abstract method for drawing, to be implemented by subclasses
    public abstract void draw();

    // can be for handling mousePressed, can be overridden by subclasses
    public  void mousePressed(float clickX, float clickY){}; // abstract method for mousePressed

    public void setup(){}
    public void mouseClicked(){}
    public void keyPressed(){}

    // return current game state
    public int getCurState(){
        return curState;
    }
    // update current game state
    public void setCurState(int newState){
        this.curState = newState;
    }

    // add score to list of scores
    public void addScore(int score){
        scores.add(score);
    }

    // return list of all scores
    public ArrayList<Integer> getScores(){
         return scores;
    }
    //return maximum score in list, or 0 if list is empty
    public int getMaxScore(){
        if(scores.isEmpty()) return 0;
        return scores.stream().max(Integer::compareTo).orElse(0);
    }
    
}

// Subclass for when the game has ended
class GameEnded extends GameController {
    
    // Constructor
    GameEnded(Main main_) {
        super(main_);
    }

    //Draw the "Game Over" screen
    public void draw() {
        main.background(0); // Black background
        main.fill(255, 0, 0); // Red text
        main.textSize(32);
        main.textAlign(PApplet.CENTER, PApplet.CENTER);
        main.text("Game Over!", main.width / 2, main.height / 2 - 100);
 
        // Display the maximum score at the top
        int maxScore = getMaxScore();
        main.fill(255); // White text for scores
        main.text("Max Score: " + maxScore, main.width / 2, main.height / 2 - 50);
 
        // Display all scores (sorted) under the max score
        ArrayList<Integer> sortedScores = new ArrayList<>(getScores());
 
        int yPosition = main.height / 2 + 50; // Starting position to display scores
        for (int score : sortedScores) {
            main.text("Score: " + score, main.width / 2, yPosition);
            yPosition += 30; // Move down for the next score
        }
 
        // Display restart instructions
        main.text("Press 'Spacebar' to Restart", main.width / 2, yPosition + 50);
        melodies.playSpecifiMelody(1);
       // melodies.start(1);
    }

   

    //checks for key press to restart the game
    @Override
    public void keyPressed(){
        if(main.key==' '){
            setCurState(GAME_BEGIN);
        }
    }

}

// Subclass for when the game is beginning
class GameBegin extends GameController {

    GameBegin(Main main_) {
        super(main_);
    }

    // press enter to start game, draws start screen of game essentially
    @Override
    public void draw() {
        main.background(200); // color fill to gray
        main.fill(0); // color fill to black
        main.textSize(32);
        main.text("Welcome to the Triangle Eater Game!", main.width / 2, main.height / 2);
        melodies.playSpecifiMelody(1);
        //melodies.start(1);
    }

   // check for key press to start game
    @Override
    public void keyPressed(){
         if(main.key==PApplet.ENTER){
            setCurState(GAME_PLAY); // sets game state to GAME_PLAY
         }
    }

}
