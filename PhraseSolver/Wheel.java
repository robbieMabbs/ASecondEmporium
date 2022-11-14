public class Wheel {
    private int[] wheel= {100,100,100,100,100,200,200,200,300,300,400,450,500,600};
    public int getValue(int x){
        return wheel[x-1];
    }
}
