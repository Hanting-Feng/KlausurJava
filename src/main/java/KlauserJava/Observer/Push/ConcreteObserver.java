package KlauserJava.Observer.Push;

public class ConcreteObserver implements Observer{
    private String observerState;
    public void update(String state){
        this.observerState = state;
        System.out.println(state);
    }
}
