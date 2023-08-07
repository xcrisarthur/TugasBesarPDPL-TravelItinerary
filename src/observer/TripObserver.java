package observer;

import java.util.Observable;
import java.util.Observer;

public class TripObserver implements Observer {
    public void update(Observable observable, Object arg) {
        TravelPlannerObservable travelPlanner = (TravelPlannerObservable) observable;
        String route = travelPlanner.getRoute();
        System.out.println("TripObserver: Perencanaan rute telah diubah menjadi " + route);
    }
}