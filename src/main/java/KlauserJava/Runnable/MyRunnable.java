package KlauserJava.Runnable;

import java.text.FieldPosition;

public class MyRunnable implements Runnable{
    String type;
    public MyRunnable(String type){
        this.type = type;
    }
    @Override
    public void run(){
        for(int i = 0;i < 5; i++){
            System.out.println(type);
        }
    }
    public static void main(String[] args) {
        MyRunnable m1 = new MyRunnable("Hi");
        MyRunnable m2 = new MyRunnable("Hello");
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        t1.start();
        t2.start();

        new Thread(()->{
            for(int i = 0; i < 5; i++){
                System.out.println("Hi");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    System.out.println("Hello");
                }
            }
        }).start();
    }
}
