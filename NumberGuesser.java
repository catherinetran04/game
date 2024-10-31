import java.util.Random;

public class NumberGuesser extends Game{
    private int secretNumber;
    private Random rng;
    private int maxGuesses;
    private int maxNumber;
    private int numGuesses;
    private boolean match;
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses){
        this.rng = rng;
        this.maxGuesses = maxGuesses;
        this.maxNumber = maxNumber;
    }
    public String getName() {
        return "NumberGuesser";
    }
    public String prepToPlay(){
        numGuesses = 0;
        match = false;
        secretNumber = rng.nextInt(maxNumber) + 1;
        return "I've picked a number 1 to " + maxNumber + ". You get " + maxGuesses + " guesses to guess it";
    }
    public boolean isOver(){
        if (numGuesses == maxGuesses) {
            return true;
        }
        if (match == true) {
            return true;
        }
        return false;
    }
    public boolean isValid(String move) {
        for (int i = 0; i < move.length(); i++){
                if (move.charAt(i) >= '0' && move.charAt(i) <= '9'){
                    numGuesses += 1;
                    return true;
                }
            }
        return false;
    }
    public String processMove(String move){
        int temp = Integer.parseInt(move);
        if (temp == secretNumber){
            match = true;
            return "That's it!";
        }
        else if (temp < secretNumber){
            return "Too Low";
        }
        else {
            return "Too High";
        }
    }
    public String finalMessage(){
        return "The number was: " + secretNumber;
    }
}