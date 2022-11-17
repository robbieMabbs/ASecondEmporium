import java.util.Scanner;
import java.io.File;
public class Board{

//gives random phrase
private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    tempPhrase = "how are you";
    
    try 
    {
      
      Scanner sc = new Scanner(new File("/workspace/ASecondEmporium/PhraseSolver/phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("/workspace/ASecondEmporium/PhraseSolver/phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    return tempPhrase;
  }

  //our code below//
  public String getPhrase(){
    return loadPhrase();
  }
  public String blanks;
  public void setBlanks(String t){
    blanks = t;
  }
  //creates the mystery phrase, from the original phrase
  public String mysteryPhrase(Board x, String phrase){
    blanks = "";
    for(int i= 0; i< phrase.length();i++){
      String letter = phrase.substring(i,i+1);
      if (letter.equals(" ")){
        blanks += " ";
      }
      else{
        blanks += "_";
      }
    }
    return blanks;
  }
  public boolean game =true;
  //sets whether the game is still playing or not
  public void setGame(boolean x){
      game = x;
  }
  //a list of all the previously guessed letters
  public String previousGuesses = "";
  //adds the guess to the list of previous guesses
  public void changePrevious(String guess){
    previousGuesses+=guess;
  }
}