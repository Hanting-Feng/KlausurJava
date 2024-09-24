package KlauserJava.ReadModifyWrite;

public class Deadlock {
    public static final Object left = new Object();
    public static final Object right = new Object();
    public static int counter = 0;
    public static int getCounter(){
        return counter++;
    }
    public static void leftRight(){
        synchronized(left){
            synchronized (right){
                for(int i = 0;i < 1000; i++){
                    getCounter();
                }
                System.out.println(counter);
            }
        }
    }
    public static void rightLeft(){
        synchronized (right){
            synchronized (left){
                getCounter();
                System.out.println(counter);
            }
        }
    }

    public static void main(String[] args) {
        leftRight();
        rightLeft();
    }
}
