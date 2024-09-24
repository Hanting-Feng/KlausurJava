package KlauserJava.Thread;



public class LockWait {
    public static Object lock = new Object();
    public static int i = 0;
    public static void main(String[] args) {
        new Thread(()->{
            while (i <= 10) {
                synchronized (lock){
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        i++;
                        lock.notifyAll();
                        if(i == 10){
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        new Thread(()->{
            while (i <= 10){
                synchronized (lock){
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        i--;
                        lock.notifyAll();
                        if(i == 0){
                            lock.wait();
                        }
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }

            }

        }).start();
    }
}
