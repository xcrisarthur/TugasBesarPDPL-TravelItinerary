package observer;
import strategy.RouteStrategy;

import java.util.Observable;

public class TravelPlannerObservable extends Observable {
    private RouteStrategy routeStrategy;
    private String route;

    public void setRouteStrategy(RouteStrategy strategy) {
        this.routeStrategy = strategy;
    }

    public void planRoute() {
        routeStrategy.planRoute();
        setChanged();
        notifyObservers();
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}