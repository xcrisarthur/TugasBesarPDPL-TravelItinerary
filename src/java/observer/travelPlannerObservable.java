package java.observer;

import java.util.Observable;

public class travelPlannerObservable extends Observable {
    private RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy strategy) {
        this.routeStrategy = strategy;
    }

    public void planRoute() {
        String routeDescription = routeStrategy.getDescription();
        setChanged();
        notifyObservers(routeDescription);
    }
}