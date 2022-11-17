public class Wheel {
    //list of wheel segments, negative value equate to bankrupt
    private int[] wheel= {100, 100, 200, 200, 300, 300, 400, 400, 500, 500, 600, 600, -100};
    public int getValue(int x){
        return wheel[x-1];
        //hi robbie
    }
}
