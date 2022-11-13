import java.util.Scanner;
public class Player {
    Scanner sc = new Scanner(System.in);
    private int number;
    private String name;
    private int money;
    public void setPlayer(int num, int mon){
        number = num;
        money = mon;
        System.out.println("Player "+ num+ "\nEnter Name:");
        name = sc.nextLine();
        System.out.println("Hello " + name + ". You have $" + money);
    }
    public String getName(){
        return name;
    }
    public int getMoney(){
        return money;
    }
    public int getNumber(){
        return number;
    }
    public boolean correctGuess;
    public void setGuess(boolean x){
        correctGuess = x;
    }
    public void guess(Board x, String phrase){
        System.out.println("Guess A Letter " + getName());
        boolean validGuess = false;
        correctGuess = false;
        String guess = "";
        while(validGuess==false){
            guess = sc.nextLine();
            guess = guess.toLowerCase();
                if(guess.length()>1){
                    System.out.println("Please Enter a Letter");
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
            if(phrase.contains(guess)){
                for(int i = 0; i<phrase.length();i++){
                    if(phrase.substring(i,i+1).equals(guess)){
                        String temp = x.blanks.substring(0,i) + guess + x.blanks.substring(i+1,x.blanks.length());
                        x.setBlanks(temp);
                        correctGuess = true;
                    }
                }
            }
            else{System.out.println("Wrong! bozo...");}
            System.out.println(x.blanks);
            if(!x.blanks.contains("_")){
                System.out.println(getName()+" Won!!!");
                x.setGame(false);
                correctGuess=false;
            }
    }
}
