package KlauserJava.Deadlock.leftRight.LockDeadlock;

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(100);
        Account account2 = new Account(70);
        new Thread(()->{
            Bank.transferMoney(account1,account2,50);
        }).start();
        new Thread(()->{
            Bank.transferMoney(account2,account1,50);
        }).start();
    }
}
