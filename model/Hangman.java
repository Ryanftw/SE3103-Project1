package model;
import utility.WordList;

public class Hangman {
    private String key;
    private int health = 5;
    
    public Hangman() {
        WordList k = new WordList();
        key = k.getWord();
    }

    public int getHealth() {
        return health; 
    }

    public String getKey() {
        return key;
    }


}
