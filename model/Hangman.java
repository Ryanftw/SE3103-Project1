package model;
import utility.WordList;
import java.util.Scanner;

public class Hangman {
    private final String key;
    private char guess;
    private int health = 5;
    boolean hasWon = false;
    boolean guessFlag = false;
    private String message = "";

    public Hangman() {
        final WordList k = new WordList();
        key = k.getWord();
        guess = ' ';
    }

    public char getGuess() {
        return guess;    
    }

    public void setGuess(char c) {
        guess = c; 
    }

}
