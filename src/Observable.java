// Page Collection Tracker

package src;

import java.util.List;

public interface Observable {
    void addObserver(Observer myObserver);
    void notifyObservers(String myEvent);
}