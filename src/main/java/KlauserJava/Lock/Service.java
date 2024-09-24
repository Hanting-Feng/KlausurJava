package KlauserJava.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
    public void doStepOne(){
        System.out.println(Thread.currentThread() + "Do Step One");
    }
    public void doStepTwo(){
        System.out.println(Thread.currentThread() + "Do Step Two");
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        var service = new Service();
        new Thread(() -> {
            lock.lock();
            try{
                if(lock.tryLock()){ // 使用tryLock检查对象是否已被锁定
                    service.doStepOne();
                    service.doStepTwo();
                }
            }finally {
                lock.unlock();
            }
        }).start();
    }
}
