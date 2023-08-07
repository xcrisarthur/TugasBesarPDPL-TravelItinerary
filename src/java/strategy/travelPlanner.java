package java.strategy;

class travelPlanner {
    private RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy strategy) {
        this.routeStrategy = strategy;
    }

    public void planRoute() {
        routeStrategy.planRoute();
    }
}
