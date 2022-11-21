package Nim;

import java.util.Scanner;
import java.util.jar.Attributes.Name;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //Asks the user to input thier name for the player
        System.out.println("What is Player 1's name?: ");
        //TO DO: Create Player 1
        String name = sc.nextLine();
        Player p1 =new Player(name);
        //Asks the user to input their name for the player.
        System.out.println("What is Player 2's name?: ");
        //TO DO: Create Player 2
        name = sc.nextLine();
        Player p2 =new Player(name);
        String again = "Literally any string";
        Player currentPlayer;
        
        //Runs the game
        while (!again.equals("q")){
            //Generates the game
            //TO DO: Create "game"
            Game game = new Game(p1,p2);
            //TO DO: Set the a random player as the current player
            if (((int)(Math.random())*1)==1){
                currentPlayer = p1;
            }
            else{currentPlayer = p2;}
            game.setFirstPlayer(currentPlayer);
            p1.adjustScore(-p1.getScore());
            p2.adjustScore(-p2.getScore());
            //This is the loop in which the game will be played
            while(!game.isComplete()){
                //TO DO
                game.takePiece(currentPlayer);
                currentPlayer = game.getNextPlayer();
            }
            System.out.println(currentPlayer.getName()+ " Won!!");
            System.out.println(p1.getName() +" had removed "+ p1.getScore()+" pieces!");
            System.out.println(p2.getName() +" had removed "+ p2.getScore()+" pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
        }
        System.out.println("Thank you for playing!");
    }
}
