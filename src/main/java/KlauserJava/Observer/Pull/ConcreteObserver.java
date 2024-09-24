package KlauserJava.Observer.Pull;

public class ConcreteObserver implements Observer{
    private String observerState;
    private ConcreteSubjet concreteSubjet;
    public ConcreteObserver(ConcreteSubjet concreteSubjet){
        this.concreteSubjet = concreteSubjet;
        this.concreteSubjet.removeObserver(this);
    }
    @Override
    public void update() {
        this.observerState = concreteSubjet.getSubjectState();
        System.out.println(observerState);
    }
}
