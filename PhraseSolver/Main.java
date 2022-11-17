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
      
      board.mysteryPhrase(board, phrase);

      // Spin wheel, check guess, if true guess again, break, if the player goes negative they get beaten up...
      while(board.game==true){
         player1.setGuess(true);
         System.out.println();
         while(player1.correctGuess == true){
            player1.menu(wheel,board,phrase);
            if(player1.getMoney()<0){board.setGame(false); System.out.println("\"Get yo money up, not yo funnny up, hrraughh.\"\n A man says as he enters from stage right.\n He slowly saunters towards you, droping his man purse on the floor, liquor bottle shattering.\nGetting closer, you feel your pulse accelerate.\n The fear is palpable.\n He grabs you by the arm, and rips it clean off.\n \"That should settle the debt...\" he coos as he slips away leaving you writhing in agony on the floor.\n GAME OVER - YOU WENT BROKE");}
            System.out.println(player1.getName()+ "'s Balance: $"+player1.getMoney());
            if(board.game==false){
               break;
            }
         } 
         //Player 2 turn
         if(board.game==true){player2.setGuess(true);}
         System.out.println();
         while(player2.correctGuess == true){
            player2.menu(wheel,board,phrase);
            if(player2.getMoney()<0){board.setGame(false); System.out.println("\"Get yo money up, not yo funnny up, hrraughh.\"\n A man says as he enters from stage right.\n He slowly saunters towards you, droping his man purse on the floor, liquor bottle shattering.\nGetting closer, you feel your pulse accelerate.\n The fear is palpable.\n He grabs you by the arm, and rips it clean off.\n \"That should settle the debt...\" he coos as he slips away leaving you writhing in agony on the floor.\n GAME OVER - YOU WENT BROKE");}
            System.out.println(player2.getName()+ "'s Balance: $"+player2.getMoney());
            if(board.game==false){
               break;
            }
         } 
      }
   }
}
