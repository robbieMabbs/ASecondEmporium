public class Main {
   public static void main(String[]args){

      //initialize variables and construct classes
      Board board = new Board();
      Player player1 = new Player();
      Player player2 = new Player();
      Wheel wheel = new Wheel();
      String phrase = board.getPhrase(); 

      //initialize players and their money
      player1.setPlayer(1, 100);
      player2.setPlayer(2, 100);

      //TESTING - DELETE
      System.out.println(phrase);
      System.out.println(board.mysteryPhrase(board, phrase));
      //END TESTING

      // Spin wheel, check guess, if true guess again,  break.
      while(board.game==true){
         System.out.print("\u001B[32m");
         player1.spin(wheel);
         player1.setGuess(true);
         while(player1.correctGuess == true){
            player1.guess(board, phrase);
            System.out.println(player1.getName()+ "'s Balance: $"+player1.getMoney());
            if(board.game==false){
               break;
            }
         } 
         //Player 2 turn
         if(board.game==true){player2.setGuess(true);}
         while(player2.correctGuess == true){
            player2.spin(wheel);
            player2.guess(board, phrase);
            System.out.println(player2.getName()+ "'s Balance: $"+player1.getMoney());
            if(board.game==false){
               break;
            }
         } 
      }
   }
}
