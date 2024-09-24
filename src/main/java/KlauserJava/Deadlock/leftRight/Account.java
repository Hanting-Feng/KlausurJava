package KlauserJava.Deadlock.leftRight;

public class Account {
    private double geld;

    @Override
    public String toString() {
        return "Account{" +
                "geld=" + geld +
                ", id=" + id +
                '}';
    }

    private static int idCounter = 1;
    private final int id;
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
