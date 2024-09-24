package KlauserJava.Observer.Push;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    public List<Observer> observers = new ArrayList<>();
    public String state;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(state);
        }
    }
    public void setState(String state){
        this.state = state;
        notifyObservers();
    }
    public String getState(){
        return state;
    }
}
