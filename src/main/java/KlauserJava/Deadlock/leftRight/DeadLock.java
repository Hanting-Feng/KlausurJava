package KlauserJava.Deadlock.leftRight;

import java.util.logging.Level;

public class DeadLock {
    public final Object left = new Object();
    public final Object right = new Object();
    public int counter = 0;
    public void doSomething(){
        counter++;
    }
    public  void leftRight(){
        synchronized(left){
            synchronized (right){
                doSomething();
            }
        }
    }
    public void rightLeft(){
        synchronized (right){
            synchronized(left){
                doSomething();
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(deadLock::rightLeft).start();
        new Thread(()->{
            deadLock.leftRight();
        }).start();
    }
}
