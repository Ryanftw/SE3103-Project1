package utility;
import java.util.Random;

public class WordList {

    private String[] words = new String[] {"communication", "science", "programming", "language", "difficulty", "artificial", "intelligence", "attempts", "screenshot", "baseball", 
    "windows", "learning", "electronics", "beautiful", "internet", "database", "organization", "application", "network", "friendly", 
    "validation", "attempts", "statistics", "physics", "chemistry", "engineering", "school", "industry", "revolution", "progress", 
    "characters", "heavily", "graphics" };

    public String getWord() {
        Random word = new Random();
        int x = word.nextInt(33);
        return words[x];
    }
    
}
