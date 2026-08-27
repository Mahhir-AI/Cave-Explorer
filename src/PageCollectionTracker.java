package src;

import java.util.ArrayList;
import java.util.List; // stores multiple observers

public class PageCollectionTracker implements Observable {
    private List<Observer> observers = new ArrayList<>(); // objects watching for events
    // this list only stores items of the data tye "Observer"
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    } // all objects passed in will receive future updates

    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public void pageCollected() {
        notifyObservers("page_collected");
    }
}