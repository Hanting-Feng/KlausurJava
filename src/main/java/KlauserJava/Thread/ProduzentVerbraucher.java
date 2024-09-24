package KlauserJava.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ProduzentVerbraucher {
    public static List<Data> list = new ArrayList<>();
    public static int maxList = 5;
    public static void main(String[] args){
        new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                synchronized(list){
                    while (list.size() == maxList){

                        try {
                            System.out.println("List Full, waiting...");
                            list.wait();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    }
                    list.add(new Data());
                    list.notifyAll();
                      System.out.println("[Thread " + Thread.currentThread().getId() +
                              " added new data. List size is " + list.size() + "]");
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                synchronized (list){
                    while (list.size() == 0){
                        try{
                            System.out.println("List Empty, waiting...");
                            list.wait();
                        }catch (Exception e){
                            throw new RuntimeException(e);
                        }
                    }
                    list.remove(0);
                    list.notifyAll();
                    System.out.println("[Thread " + Thread.currentThread().getId() +
                            " consumed data. List size is " + list.size() + "]");
                }
            }
        }).start();
    }
}
