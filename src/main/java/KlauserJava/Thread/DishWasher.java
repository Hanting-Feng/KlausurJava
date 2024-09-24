package KlauserJava.Thread;

import java.util.ArrayList;
import java.util.List;

public class DishWasher {
    public static void main(String[] args){
        int maxTeller = 20;
        int dishWasherZahl = 3;
        List<Teller> list = new ArrayList<>();
        for(int i = 0; i < dishWasherZahl; i++){
            new Thread(()->{
                while (!Thread.currentThread().isInterrupted()){
                    synchronized (list){
                        while (list.size() == maxTeller){
                            try {
                                list.wait();
                            }catch (Exception e){
                                throw new RuntimeException(e);
                            }
                        }
                        list.add(new Teller());
                        list.notifyAll();
                        System.out.println("Add" + "洗碗机的碗个数" + list.size());
                    }
                }
            }).start();
        }

        for(int i = 0; i < Waiter.waiterZahl; i++){
            new Thread(()->{
                while (true){
                    synchronized (list){
                        while (list.size() == 0){
                            try {
                                list.wait();
                            }catch (Exception e){
                                throw new RuntimeException(e);
                            }
                        }
                        list.remove(0);
                        list.notifyAll();
                        System.out.println("Remove" + "洗碗机的碗个数" + list.size());
                    }
                }
            }).start();
        }
    }
}
