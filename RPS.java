import java.util.Random;

public class RPS extends Game {
    private int num;
    private String[] obj = {"rock", "paper", "scissors"};
    private Random rng;
    private int wins;
    private int loss;
    private int requiredWins;
    private int maxLosses;
    public RPS(Random rng, int requiredWins, int maxLosses){
        this.rng = rng;
        this.requiredWins = requiredWins;
        this.maxLosses = maxLosses;
    }

    /**
     * updates the state of the object ot be the beginning of a new game.
     */
    public String prepToPlay(){
        wins = 0;
        loss = 0;
        return "Enter rock, paper, or scissors. Beat me " + requiredWins + " before I win " + maxLosses + " times!";
    }

    /**
     * checks if the current state of the game is done(win or lose)
     */
    public boolean isOver(){
        if (wins == requiredWins || loss == maxLosses){
            return true;
        }
        return false;
    }

    /**
     * checks if the given string represents a valid move
     */
    public boolean isValid(String move){
        if (move.equals("rock") || move.equals("scissors") || move.equals("paper")){
            num = rng.nextInt(3);
            return true;
        }
        return false;
    }

    /**
     * takes a valid move and updates the game-state based on the user's move
     */
    public String processMove(String move){
        System.out.print(obj[num] + " vs. " + move + " ");
        if (obj[num].equals(move) == false){
            if(obj[num].equals("rock") == true){
                if(move.equals("paper") == true){
                    wins++;
                    return "you Win";
                }
                else {
                    loss++;
                    return "you lose";
                }
            }
            if(obj[num].equals("paper") == true){
                if(move.equals("scissors") == true){
                    wins++;
                    return "you Win";
                }
                else {
                    loss++;
                    return "you lose";
                }
            }
            if(obj[num].equals("scissors") == true){
                if(move.equals("rock") == true){
                    wins++;
                    return "you Win";
                }
                else {
                    loss++;
                    return "you lose";
                }
            }
        }
        return "We Tie";
    }

    /**
     * returns a "final string" to the user at the end of the game
     */
    public String finalMessage(){
        if (wins == requiredWins){
            return "You win the set";
        }
        return "You lose the set";
    }

    public String getName() {
        return "Rock Paper Scissors";
    }
}