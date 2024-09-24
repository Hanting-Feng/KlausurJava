package KlauserJava.Runnable;

public class MyThread extends Thread{
    String type;
    public MyThread(String type){
        this.type = type;
    }
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(type);
        }
    }

    public static void main(String[] args) {
        MyThread m1 = new MyThread("Hi");
        MyThread m2 = new MyThread("Hello");
        m1.start(); // 访问run方法
        m2.start();
    }
}
