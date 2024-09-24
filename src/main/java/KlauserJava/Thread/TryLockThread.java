package KlauserJava.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockThread {
    public static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try{
                    Thread.sleep(10);
                }catch (Exception e){e.printStackTrace();}
                if(lock.tryLock()){
                    System.out.println(Thread.currentThread().getName() + ":" + "2");
                    lock.unlock();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                try{
                    Thread.sleep(10);
                }catch (Exception e){e.printStackTrace();}
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ":" + "5");
                lock.unlock();
            }
        }).start();
    }
}
