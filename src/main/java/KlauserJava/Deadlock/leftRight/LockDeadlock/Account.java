package KlauserJava.Deadlock.leftRight.LockDeadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
        private static int idCounter = 1;
        private final int id;
        private double geld;
        public Lock lock = new ReentrantLock();

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", geld=" + geld +
                ", lock=" + lock +
                '}';
    }

    public Account(double geld){
            this.id = idCounter++;
            this.geld = geld;
        }
        public double credit(double amount){
            geld += amount;
            return geld;
        }
        public double debit(double amount){
            geld -= amount;
            return geld;
        }
        public double getId(){
            return id;
        }
}
