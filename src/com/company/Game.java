package com.company;
import java.util.Scanner;

public class Game {
    private String movieToGuess;
    private String movieToShow = "";
    private int numGuessesLeft = 10;
    private Scanner scanner = new Scanner(System.in);
    private boolean won = false;
    private String letters = "";

    Game(String movieToGuess) {
        this.movieToGuess = movieToGuess;
        int len = movieToGuess.length();

        for (int i = 0; i < len; i++) {
            if (this.movieToGuess.charAt(i) == ' '){
                movieToShow += " ";
            } else {
                movieToShow += "_";
            }
        }
        System.out.println("Guess a movie name of " + movieToGuess.length() + " letters.");
        System.out.println(movieToGuess);
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
                char letter = guess.charAt(0);
                addLetter(letter);
                System.out.println("The movie name really contains a '" + guess + "'.");
            } else {
                System.out.println("The movie name doesn't contain a '" + guess + "'.");
            }
        } else if (guess.equals(movieToGuess)) {
            win();
            System.out.println("Correct! You rock.");
        } else {
            System.out.println("Incorrect! Try again.");
        }
    }

    private void addLetter(char letter){
        letters += letter;
        int len = movieToGuess.length();
        movieToShow = "";

        for (int i = 0; i < len; i++) {
            if (movieToGuess.charAt(i) == ' '){
                movieToShow += " ";
            } else if (letters.indexOf(movieToGuess.charAt(i)) == -1){
                movieToShow += "_";
            } else {
                movieToShow += movieToGuess.charAt(i);
            }
        }
    }

    private void win(){
        won = true;
    }

    public boolean hasWon() {
        return won;
    }
}
