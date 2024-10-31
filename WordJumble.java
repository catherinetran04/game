import java.util.Random;

public class WordJumble extends Game{
    private String hiddenWord;
    private int maxGuesses;
    private WordsList w1;
    private Random rng;
    private int minWordLen;
    private int maxWordLen;
    private String jumbledWord;
    private boolean match;
    private int guess;

    public WordJumble(WordsList w1, Random rng, int minWordLen, int maxWordLen, int maxGuesses){
        this.w1 = w1;
        this.rng = rng;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
    }

    public String prepToPlay(){
        guess = 0;
        match = false;
        jumbledWord = "";
        hiddenWord = w1.getWord(minWordLen,maxWordLen);
        String [] letter = hiddenWord.split("");
        for (int i = letter.length-1; i > 0; i--){
            int j = rng.nextInt(i);
            String temp = letter[i];
            letter[i] = letter[j];
            letter[j] = temp;
        }
        for (int i = 0; i < letter.length; i++){
            jumbledWord += letter[i];
        }

        return "The following is a jumbled up word: " + jumbledWord + " You get " + maxGuesses + " guesses to guess it";
    }
    /**
     * checks if the current state of the game is done(win or lose)
     */
    public boolean isOver() {
        if (match == true){
            return true;
        }
        if (guess == maxGuesses){
            return true;
        }
        return false;
    }
    /**
     * checks if the given string represents a valid move
     */
    public boolean isValid(String move) {
        return true;
    }
    /**
     * takes a valid move and updates the game-state based on the user's move
     */
    public String processMove(String move) {
        guess++;
        if (move.equals(hiddenWord) == true) {
            match = true;
            return null;
        }

        return "That's not it";
    }
    /**
     * returns a "final string" to the user at the end of the game
     */
    public String finalMessage(){
        return "The word was " + hiddenWord;
    }
    /**
     * returns name of the game
     */
    public String getName(){
        return "Word Jumble";
    }
}