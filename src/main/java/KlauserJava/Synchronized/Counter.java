package KlauserJava.Synchronized;

public class Counter{
    private int count = 0; // count 是共享的，理论输出不足2000
    public int getCount() {
        return count++;
    }
    public static void main(String[] agrs){
        Counter counter = new Counter();
        Runnable task = () -> {
            for(int i = 0; i < 1000; i++){
                counter.getCount();
            }
            System.out.println(counter.getCount());
        }; // 两个线程共同修改一个变量
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}
