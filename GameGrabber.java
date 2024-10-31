import java.util.Random;
import java.util.Scanner;

public class GameGrabber{
    private Game[] game;
    private Scanner user;
    private String input = "";

    /**
     * take array of game objects and a scannner object to use for all user input
     */
    public GameGrabber(Game[] game, Scanner user){
        this.game = game;
        this.user = user;
    }

    /**
     * start a loop that allows user to pick and play games until they decide to quit
     */
    public void doMenu() {
        Boolean end = false;
        while (input != "quit" && end == false) {
            for (int i = 0; i <= game.length; i++) {
                if (i != game.length) {
                    System.out.println(i + ") " + game[i].getName());
                } else {
                    System.out.println(i + ") Quit");
                }
            }
            System.out.print("Pick a game (0-" + game.length + ") ");
            input = user.next();
            while (Integer.parseInt(input) < 0 || Integer.parseInt(input) > game.length) {
                System.out.print("Pick a game (0-" + game.length + ") ");
                input = user.next();
            }
            if (Integer.parseInt(input) == game.length){
                System.out.println("goodbye");
                end = true;
            } else {
                game[Integer.parseInt(input)].play(user);
            }
        }

    }

    /**
     * public method that creates gameGrabber object, gives it an array of each the 4 games and calls doMenu
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        WordsList w = new WordsList(r);
        Game[] games = new Game[]{ new Hangman(w, 4, 9, 10),
            new NumberGuesser(r, 72, 5),
            new RPS(r, 10, 10),
            new WordJumble(w, r, 2, 10, 5)
        };
        GameGrabber obj = new GameGrabber(games, scan);
        obj.doMenu();

    }
}