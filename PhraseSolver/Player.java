import java.util.Scanner;
public class Player {
    Scanner sc = new Scanner(System.in);
    private int number;
    private String name;
    private int money;
    private int value;
    public void setPlayer(int num, int mon){
        number = num;
        money = mon;
        System.out.println("Player "+ num+ "\nEnter Name:");
        name = sc.nextLine();
        System.out.println("Hello " + name + ". You have $" + money);
    }

    //Getters
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

    //
    public boolean correctGuess;
    public void setGuess(boolean x){
        correctGuess = x;
    }


    //Prompts player to guess and then compares guess to previous guesses and makes sure it's one letter
    public void guess(Board x, String phrase){
        System.out.println("Guess A Letter " + getName());
        boolean validGuess = false;
        correctGuess = false;
        String guess = "";
        while(validGuess==false){
            guess = sc.nextLine();
            guess = guess.toLowerCase();
                if(guess.length()>1){
                    System.out.println("Please Enter a LETTER");
                }
                else{
                    if(x.previousGuesses.contains(guess)){
                        System.out.println("Please Enter a Letter That Hasn't Been Used");
                    }
                    else{
                        x.changePrevious(guess);
                        validGuess = true;
                    }
                }
            }

            //Correct guess protocol. Replaces blanks that are the correctly guessed letter with that letter for display.
            if(phrase.contains(guess)){
                money+=(phrase.length()-phrase.replace(guess,"").length())*getValue();
                for(int i = 0; i<phrase.length();i++){
                    if(phrase.substring(i,i+1).equals(guess)){
                        String temp = x.blanks.substring(0,i) + guess + x.blanks.substring(i+1,x.blanks.length());
                        x.setBlanks(temp);
                        correctGuess = true;
                    }
                }
            }
            //If wrong insult and reprint phrase
            else{System.out.println("Wrong! bozo...");}
            System.out.println(x.blanks);

            //If there are no blanks left end the game in a win
            if(!x.blanks.contains("_")){
                System.out.println(getName()+" Won!!!");
                x.setGame(false);
                correctGuess=false;
            }
    }

    //spin the wheel!
    public void spin(Wheel x){
        value = x.getValue((int)(Math.random()*14));
        System.out.println("You spun and landed on $" + value + ".");
    }
}
