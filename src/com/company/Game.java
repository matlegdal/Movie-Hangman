package com.company;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private String movieToGuess;
    private String movieToShow;
    private int numGuessesLeft = 10;
    private Scanner scanner = new Scanner(System.in);
    public boolean hasWon = false;

    Game(String movieToGuess) {
        this.movieToGuess = movieToGuess;
        this.movieToShow = String.join("", Collections.nCopies(this.movieToGuess.length(), "_"));
        System.out.println("Guess a movie name of " + movieToGuess.length() + " letters.");
    }

    private void displayGuess() {
        System.out.println(movieToShow);
    }

    public void playTurn() {
        this.displayGuess();
        System.out.println("Guess the name of the movie or guess a letter.");
        System.out.println(numGuessesLeft + " guess(es) left.");
        String guess = scanner.nextLine();
        this.checkGuess(guess);
        numGuessesLeft--;
    }

    private void checkGuess(String guess) {
        if (guess.length() == 1) {
            this.checkLetter(guess);
        } else if (guess.equals(movieToGuess)) {
            this.win();
        }
    }

    private void checkLetter(String guess) {

    }

    private void win(){
        hasWon = true;
    }

}
