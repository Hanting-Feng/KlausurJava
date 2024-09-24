package KlauserJava.Synchronized;

public class SychronizedCounter {
    private int count = 0; // count 是共享的,理论输出2000

    public synchronized int getCount() {
        return count++;
    } // 两个线程同时修改一个变量，用synchronized，可以防止数据丢失
    public static void main(String[] agrs){
        SychronizedCounter counter = new SychronizedCounter();
        Runnable task = () -> {
            for(int i = 0; i < 1000; i++){
                counter.getCount();
            }
            System.out.println(counter.getCount());
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
