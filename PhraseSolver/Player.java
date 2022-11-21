import java.util.Scanner;
public class Player {
    Scanner sc = new Scanner(System.in);
    private int number;
    private String name;
    private int money;
    private int value;
    public boolean correctGuess;
    
    //Getters +Setters
    public String getName(){
        return name;
    }
    public int getMoney(){
        return money;
    }
    public int getNumber(){
        return number;
    }
    public int getValue(){
        return value;
    }

    public void setGuess(boolean x){
        correctGuess = x;
    }

    //Text Colour Changers
    public void playerColour(){
        if(getNumber()==1){
            System.out.print("\033[0;32m");//sets green text
        }
        else if(getNumber()==2){
            System.out.print("\033[0;34m");//sets blue text
        }
    }
    public void resetText(){System.out.print("\033[0m"); }//resets text

    //Method for getting player info
    public void setPlayer(int num, int mon){
        number = num;
        money = mon;
        System.out.println("Player "+ num+ "\nEnter Name:");
        name = sc.nextLine();
        playerColour();
        System.out.println("Hello " + name + ". You have $" + money);
        resetText();
    }

    //What happens when a player guesses a consonant
    public void guess(Board x, String phrase){
        boolean validGuess = false;
        correctGuess = false;
        if(getValue()>0){ //if the wheel lands on bankrupt (value less than 0) a player cannot guess letters
            System.out.println("Guess A Consonant, " + getName());
            String guess = "";
            while(validGuess==false){ //will repeatedly ask for a consonant until one is given (numbers and symbols are accepted as consonants but f you choose that you're bad at Wheel of Fortune)
                guess = sc.nextLine();
                guess = guess.toLowerCase();
                    if(guess.length()>1||guess.equals("a")||guess.equals("e")||guess.equals("i")||guess.equals("o")||guess.equals("u")){ //is it a single character and not a vowel?
                        System.out.println("Please Enter a CONSONANT");
                    }
                    else{
                        if(x.previousGuesses.contains(guess)){//checks to see if it has been guessed before
                            System.out.println("Please Enter a Letter That Hasn't Been Used");
                        }
                        else{
                            x.changePrevious(guess); //updates list of previous guesses
                            validGuess = true;
                        }
                    }
                //Correct guess protocol. Replaces blanks that are the correctly guessed letter with that letter for display.
                if(phrase.contains(guess)){
                        money+=(phrase.length()-phrase.replace(guess,"").length())*getValue(); //adds money (value of wheel times number of guess occurrences)
                    for(int i = 0; i<phrase.length();i++){
                        if(phrase.substring(i,i+1).equals(guess)){
                            String temp = x.blanks.substring(0,i) + guess + x.blanks.substring(i+1,x.blanks.length());
                            x.setBlanks(temp);
                            correctGuess = true;
                        }
                    }
                    System.out.println(x.blanks);
                }
                //If wrong insult and reprint phrase
                else{System.out.println("Wrong! bozo..."); System.out.println(x.blanks);}
                //If there are no blanks left end the game in a win
                if(!x.blanks.contains("_")){
                    System.out.println(getName()+" Won!!!");
                    x.setGame(false);
                    correctGuess=false;
                }
            }
        }
    }

    //spin the wheel!!!!
    public void spin(Wheel x){
        value = x.getValue((int)(Math.random()*12)+1);
        if(getValue()>0){System.out.println("You spun and landed on $" + value + ".");}
        else{System.out.println("You Spun the Wheel and Landed on Bankrupt :("); money= 0;}
    }

    //menu that is displayed each turn 
    public void menu(Wheel wheel, Board board, String phrase){
        boolean validGuess = false;
        while(validGuess==false){//checks to see if a valid input is made
            System.out.println(board.blanks);
            playerColour(); //changes text to the players colour
            System.out.println("Would " +getName()+ " like to... \n [1] Guess a Consanant?\n [2] Pay for a Vowel? (Costs $250)\n [3] Guess the Word?");
            resetText(); //resets text
            String input = sc.nextLine();  
            if(input.equals("1")){
                    spin(wheel);
                    guess(board,phrase);
                    validGuess=true;
                }
            else if(input.equals("3")){
                System.out.println("Guess the Word: ");
                String guess = sc.nextLine();
                guess.toLowerCase();
                if(guess.equals(phrase)){System.out.println("Hooray! You won!"); board.setGame(false);} //what happens if the phrase matches exactly
                else{System.out.println("Better Luck Next Time");}
                validGuess=true;
                correctGuess=false;
            }
            else if(input.equals("2")){
                money-=250; //a vowel costs $250
                validGuess=false;
                while (validGuess==false){
                    System.out.println("Guess a Vowel, " + getName());
                    String guess = sc.nextLine();
                    if(guess.length()>1||!(guess.equals("a")||guess.equals("e")||guess.equals("i")||guess.equals("o")||guess.equals("u"))){
                        System.out.println("Please Enter a VOWEL");
                    }
                    else if(board.previousGuesses.contains(guess)){
                        System.out.println("Please Enter a Letter That Hasn't Been Used");
                    }
                    else if(phrase.contains(guess)){ //if the vowel is in the word, it updates the board
                        for(int i = 0; i<phrase.length();i++){
                            if(phrase.substring(i,i+1).equals(guess)){
                                String temp = board.blanks.substring(0,i) + guess + board.blanks.substring(i+1,board.blanks.length());
                                board.setBlanks(temp);
                            }
                            board.changePrevious(guess);
                        }
                        correctGuess = true;
                        System.out.println(board.blanks);
                        validGuess=true;
                    }
                    //If wrong insult and reprint phrase
                    else{System.out.println("Not in the Word! bozo...");
                        validGuess=true;
                        correctGuess=false;
                        System.out.println(board.blanks);
                    }
                }
            }
            else{System.out.println("Please Enter a Valid Choice");}   
        }
    }
    public String getScore() {
        return null;
    }
}

