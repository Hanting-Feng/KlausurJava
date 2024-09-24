package KlauserJava.ReadModifyWrite;

import KlauserJava.Deadlock.leftRight.DeadLock;

import java.nio.channels.NonWritableChannelException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Severs severs = new Severs();
        for(int i = 0; i < 10; i++){
            new Thread(()->{
                while (true){
                    lock.lock();
                    try {
                        if(lock.tryLock()){
                            severs.doOne();
                            severs.doTwo();
                        }
                    }finally {
                        lock.unlock();
                    }
                }
                /*while (true){
                    lock.lock();
                    severs.doOne();
                    severs.doTwo();
                    lock.unlock();
                }*/
            }).start();
        }
    }

}
