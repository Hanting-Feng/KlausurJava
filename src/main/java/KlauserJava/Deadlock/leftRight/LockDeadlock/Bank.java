package KlauserJava.Deadlock.leftRight.LockDeadlock;

public class Bank {
    public static void transferMoney(Account fromAcc,Account toAcc, double amount){
        if(fromAcc.lock.tryLock()){
            try{
                if(toAcc.lock.tryLock()){
                    try{
                        transfer(fromAcc,toAcc,amount);
                    }finally{
                        toAcc.lock.unlock();
                    }
                }
            }finally {
                fromAcc.lock.unlock();
            }
        }
    }
    public static void transfer(Account fromAcc, Account toAcc, double amount){
        fromAcc.debit(amount);
        toAcc.credit(amount);
        System.out.println(fromAcc);
        System.out.println(toAcc);
    }
}
