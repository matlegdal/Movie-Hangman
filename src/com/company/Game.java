package com.company;
import java.util.Collections;

public class Game {
    private String movieToGuess;
    private String movieToShow;

    Game(String movieToGuess) {
        this.movieToGuess = movieToGuess;
        this.movieToShow = String.join("", Collections.nCopies(this.movieToGuess.length(), "_"));
        System.out.println("Guess a movie name of " + movieToGuess.length() + " letters.");
    }

    public void displayGuess() {
        System.out.println(movieToShow);

    }
}
