package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String movieToGuess = chooseMovie();

        if (movieToGuess != null) {
            Game game = new Game(movieToGuess);
            game.displayGuess();

        } else {
            System.out.println("Something seems wrong with the file of movies or the code.");
        }
    }

    private static String chooseMovie() {
        String[] movies = new String[30];

        try {
            File moviesFile = new File("movies.txt");
            Scanner scanner = new Scanner(moviesFile);
            int i = 0;
            while (scanner.hasNextLine() && i < 30){
                movies[i] = scanner.nextLine();
                i++;
            }
            return movies[(int) (Math.random()*i)];
        } catch (FileNotFoundException e) {
            System.out.println("movies.txt is not found");
        }
        return null;
    }
}
