package KlauserJava.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockThread {
    public static Lock lock = new ReentrantLock();
    public static boolean flag = true;
    public static int i = 0;
    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            while (i < 10){
                lock.lock();
                if(flag){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + LockThread.i);
                    i++;
                    flag = false;
                    lock.unlock();
                }
                else {
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(()->{
            while (i < 10){
                lock.lock();
                if(!flag){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    i++;
                    flag = true;
                    lock.unlock();
                }
                else {
                    lock.unlock();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
