package KlauserJava.Deadlock.leftRight;

import javax.management.MBeanNotificationInfo;

public class Bank {
    public static void transferMoney(Account fromAcc, Account toAcc,double amount){
        if(fromAcc.getId() < toAcc.getId()){
            synchronized (fromAcc){
                synchronized (toAcc){
                    transfer(fromAcc,toAcc,amount);
                }
            }
        }else{
            synchronized (toAcc){
                synchronized (fromAcc){
                    transfer(fromAcc,toAcc,amount);
                }
            }
        }
    }
    private static void transfer(Account fromAcc, Account toAcc, double amount){
        fromAcc.debit(amount);
        toAcc.credit(amount);
        System.out.println(fromAcc);
        System.out.println(toAcc);
    }
}
