package KlauserJava.Thread;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProduzentVerbraucherLock {
    public static int maxAnzahl = 5;
    public static List<Data> list = new ArrayList<>();
    public static void main(String[] args){
        Lock lock = new ReentrantLock();
        var conditionFull = lock.newCondition();
        var conditionEmpty = lock.newCondition();
        new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                lock.lock();
                while (list.size() == maxAnzahl){
                    System.out.println("List Full, waiting...");
                    try {
                        conditionFull.await();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                list.add(new Data());
                System.out.println("Data added, New size = " + list.size());
                conditionEmpty.signalAll();
                lock.unlock();
            }

        }).start();
        new Thread(()->{
            while (true){
                lock.lock();
                while (list.size() == 0){
                    System.out.println("List Empty, waiting...");
                    try {
                        conditionEmpty.await();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                list.remove(0);
                System.out.println("Element remove. New size =" + list.size());
                conditionFull.signalAll();
                lock.unlock();
            }

        }).start();
    }

}
