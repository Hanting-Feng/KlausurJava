package KlauserJava.Observer.Pull;

import KlauserJava.Observer.Push.ConcreteSubject;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubjet implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String subjectState;
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
            observer.update();
        }
    }
    public void setSubjectState(String state){
        this.subjectState = state;
        notifyObservers();
    }
    public String getSubjectState(){
        return subjectState;
    }

}
