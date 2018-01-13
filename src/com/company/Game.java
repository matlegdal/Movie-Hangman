package com.company;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private String movieToGuess;
    private String movieToShow;
    private int numGuessesLeft = 10;
    private Scanner scanner = new Scanner(System.in);
    public boolean hasWon = false;
    private String letters = "";

    Game(String movieToGuess) {
        this.movieToGuess = movieToGuess;
        this.movieToShow = String.join("", Collections.nCopies(this.movieToGuess.length(), "_"));
        System.out.println("Guess a movie name of " + movieToGuess.length() + " letters.");
    }

    private void displayGuess() {
        System.out.println(movieToShow);
    }

    public void playTurn() {
        displayGuess();
        System.out.println("Guess the name of the movie or guess a letter.");
        System.out.println(numGuessesLeft + " guess(es) left.");
        String guess = scanner.nextLine();
        checkGuess(guess);
        numGuessesLeft--;
    }

    private void checkGuess(String guess) {
        if (guess.length() == 1) {
            if (letters.contains(guess)) {
                System.out.println("You have already guessed the letter " + guess);
                return;
            }

            if (movieToGuess.contains(guess)){
                addLetter(guess);
            }
        } else if (guess.equals(movieToGuess)) {
            win();
        }
    }

    private void addLetter(String guess){
        int len = movieToShow.length();
        char letter = guess.charAt(0);
        movieToShow = "";
        for (int i = 0; i < len; i++) {
            if (movieToGuess.charAt(i) != letter){
                movieToShow += "_";
            } else {
                movieToShow += letter;
            }
        }
    }

    private void win(){
        hasWon = true;
    }

}
