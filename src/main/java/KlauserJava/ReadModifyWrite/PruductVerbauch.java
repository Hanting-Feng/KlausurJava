package KlauserJava.ReadModifyWrite;

import java.util.ArrayList;
import java.util.List;

public class PruductVerbauch {
    public static int maxAnzahl = 10;
    public static List<Platz> parking = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                synchronized (parking){
                    while (parking.size() == maxAnzahl){
                        try {
                            parking.wait();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    parking.add(new Platz());
                    parking.notifyAll();
                    System.out.println("剩余车位" + parking.size());
                }
            }

        }).start();
        new Thread(()->{
            while (true) {
                synchronized (parking) {
                    while (parking.size() == 0) {
                        try {
                            parking.wait();
                        } catch (Exception e) {
                            throw new RuntimeException();
                        }
                    }
                    parking.remove(0);
                    parking.notifyAll();
                }
            }
        }).start();
    }
}
