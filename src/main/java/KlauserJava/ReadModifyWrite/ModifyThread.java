package KlauserJava.ReadModifyWrite;

public class ModifyThread {
    public static int counter;
    public synchronized static void getCounter(){
        counter++;
    }

    public static void main(String[] args) {
        Runnable runnable = ()->{
            for(int i = 0; i < 1000; i++){
                getCounter();
            }
            System.out.println(counter);
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        /*for(int i = 0; i < 1000; i++){
            getCounter();
        }
        System.out.println(counter);*/
    }
}
