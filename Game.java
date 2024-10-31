import java.util.Scanner;

public abstract class Game {
    /**
     * updates the state of the object ot be the beginning of a new game.
     */
    protected abstract String prepToPlay();
    /**
     * checks if the current state of the game is done(win or lose)
     */
    protected abstract boolean isOver();
    /**
     * checks if the given string represents a valid move
     */
    protected abstract boolean isValid(String move);
    /**
     * takes a valid move and updates the game-state based on the user's move
     */
    protected abstract String processMove(String move);
    /**
     * returns a "final string" to the user at the end of the game
     */
    protected abstract String finalMessage();
    /**
     * returns name of the game
     */
    public abstract String getName();
    /**
     * implement the general game outline
     */
    public void play(Scanner user) {
        Boolean end = false;
        System.out.println(prepToPlay());
        while (isOver() == false && end == false) {
            System.out.print("Enter Your Move or 'quit' to quit> ");
            String input = user.next();
            while (isValid(input) == false && input.equals("quit") == false) {
                System.out.print("Invalid Move! try again> ");
                input = user.next();
            }
            String p = processMove(input);
            if (p != null && input.equals("quit") == false) {
                System.out.println(p);
            }
            if (input.equals("quit") == true){
                end = true;
            }
        }
        System.out.println(finalMessage());
    }
}