package strategy;

public class RouteStrategyFactory {
    public static RouteStrategy createRouteStrategy(int routeChoice) {
        switch (routeChoice) {
            case 1:
                return new HistoricalRoute();
            case 2:
                return new NatureAndSportsRoute();
            // Tambahkan kasus untuk rute perjalanan baru jika diperlukan
            default:
                return null;
        }
    }
}

