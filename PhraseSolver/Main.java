import java.util.Scanner;
public class Main {
   public static void main(String[]args){
      Board board = new Board();
      Player player1 = new Player();
      Player player2 = new Player();
      String phrase = board.getPhrase();
      player1.setPlayer(1, 100);
      player2.setPlayer(2, 100);
      System.out.println(phrase);
      System.out.println(board.mysteryPhrase(board, phrase));
      while(board.game==true){  
         player1.setGuess(true);
         while(player1.correctGuess == true){
            player1.guess(board, phrase);
            if(board.game==false){
               break;
            }
         } 
         if(board.game==true){player2.setGuess(true);}
         while(player2.correctGuess == true){
            player2.guess(board, phrase);
            if(board.game==false){
               break;
            }
         } 
      }
   }
}