package java.observer;

import java.util.Observable;
import java.util.Observer;

public class TripObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String message = (String) arg;
        System.out.println("Notifikasi: " + message);
    }
}
