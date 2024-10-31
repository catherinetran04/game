public class Hangman extends Game{
    private String hiddenWord;
    int minWordLen;
    int maxWordLen;
    private String current;
    WordsList words;

    private int numGuesses;
    private final int maxGuesses;
    public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses){
        this.words = words;
        this.minWordLen = minWordLen;
        this.maxWordLen = maxWordLen;
        this.maxGuesses = maxGuesses;
    }
    /**
     * pick a new word based on the input parameters, and set up all
     * other private variables to prep for a new round of hangman.
     */
    public String prepToPlay() {
        hiddenWord = words.getWord(minWordLen,maxWordLen);
        current = "";
        numGuesses = 0;
        for (int i = 0; i < hiddenWord.length(); i++){
            current += "_";
        }
        return "I've picked a " + hiddenWord.length() + " letter word. Guess letters you think are in the word. You get " + maxGuesses + " guesses.";
    }

    /**
     * game is over is player has guessed every letter in the word
     * or if they have reached their maximum move limit
     */
    public boolean isOver() {
        if (numGuesses == maxGuesses) {
            return true;
        }
        if (current.equals(hiddenWord)) {
            return true;
        }
        return false;
    }

    /**
     * move is valid only if it is a single letter
     */
    public boolean isValid(String move){
        if (move.length() == 1) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * processing a move: recording the guessed letter and return the new "hint"
     */
    public String processMove(String move){
        numGuesses += 1;
        String current2 = "";
        for (int i = 0; i < hiddenWord.length(); i++){
            if (String.valueOf(hiddenWord.charAt(i)).equals(move)) {
                current2 += move;
            }
            else if (String.valueOf(current.charAt(i)) != "_"){
                current2 += current.charAt(i);
            }
            else {
                current2 += "_";
            }
        }
        current = current2;
        return current;
    }

    /**
     * final message indicates what the secret word was
     */
    public String finalMessage(){
        return "The word was: " + hiddenWord;
    }

    public String getName(){
        return "Hangman";
    }
}