package KlauserJava.Deadlock.leftRight;

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(100);
        Account account2 = new Account(70);

        Thread thread1 = new Thread(()->{
            Bank.transferMoney(account1,account2,50);
        });
        thread1.start();
        new Thread(()->{
            Bank.transferMoney(account2,account1,50);
        }).start();
    }
}
