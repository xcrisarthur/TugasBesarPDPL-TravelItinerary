import java.util.Scanner;
import abstractfactory.Transport;
import abstractfactory.TransportFactory;
import abstractfactory.CarFactory;
import abstractfactory.AirplaneFactory;

import strategy.TravelPlanner;
import strategy.HistoricalRoute;
import strategy.NatureAndSportsRoute;

import decorator.Museum;
import decorator.TouristAttraction; // Hanya satu impor untuk TouristAttraction
import decorator.TourGuideDecorator;
import decorator.FoodPackageDecorator;

import factory.Attraction;
import factory.AttractionFactory;

import chainofresponsibility.EveningActivityHandler;
import chainofresponsibility.ShowHandler;
import chainofresponsibility.ConcertHandler;

import observer.TripObserver;
import observer.TravelPlannerObservable;

import flyweight.ParkFlyweightFactory;
import flyweight.TouristAttractionflyweight;

import singleton.ClosingActivity;

import adapter.PaymentProcessor;
import adapter.CashPaymentProcessor;
import adapter.CreditCardPaymentProcessor;

import facade.ShoppingFacade;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ABSTRACT FACTORY PATTERN
        System.out.println("Choose transport type: 1 - Car, 2 - Airplane");
        int transportChoice = scanner.nextInt();

        TransportFactory transportFactory;
        if (transportChoice == 1) {
            transportFactory = new CarFactory();
        } else {
            transportFactory = new AirplaneFactory();
        }

        Transport transport = transportFactory.createTransport();
        transport.travel();

        // STRATEGY PATTERN
        System.out.println("Choose route type: 1 - Historical, 2 - Nature and Sports");
        int routeChoice = scanner.nextInt();

        TravelPlanner travelPlanner = new TravelPlanner();
        if (routeChoice == 1) {
            travelPlanner.setRouteStrategy(new HistoricalRoute());
        } else {
            travelPlanner.setRouteStrategy(new NatureAndSportsRoute());
        }

        travelPlanner.planRoute();

        // DECORATOR PATTERN
        TouristAttraction museum = new Museum();
        TouristAttraction museumWithGuide = new TourGuideDecorator(museum);
        TouristAttraction museumWithGuideAndFood = new FoodPackageDecorator(museumWithGuide);

        System.out.println("Museum without guide and food:");
        museum.visit();

        System.out.println("\nMuseum with guide:");
        museumWithGuide.visit();

        System.out.println("\nMuseum with guide and food:");
        museumWithGuideAndFood.visit();

        // FACTORY PATTERN
        System.out.println("Choose attraction type: 1 - Park, 2 - Museum");
        int attractionChoice = scanner.nextInt();

        AttractionFactory attractionFactory = new AttractionFactory();
        Attraction attraction;
        if (attractionChoice == 1) {
            attraction = attractionFactory.createAttraction("park");
        } else {
            attraction = attractionFactory.createAttraction("museum");
        }

        attraction.visit();

        // CHAIN OF RESPONSIBILITY PATTERN
        EveningActivityHandler eveningActivityHandler = new ShowHandler();
        EveningActivityHandler concertHandler = new ConcertHandler();

        eveningActivityHandler.setNext(concertHandler);

        System.out.println("Choose evening activity: 1 - Show, 2 - Concert, 3 - Movie");
        int activityChoice = scanner.nextInt();

        String activity;
        if (activityChoice == 1) {
            activity = "show";
        } else if (activityChoice == 2) {
            activity = "concert";
        } else {
            activity = "movie";
        }

        eveningActivityHandler.handleActivity(activity);

        // OBSERVER PATTERN
        TripObserver tripObserver = new TripObserver();
        TravelPlannerObservable travelPlannerObservable = new TravelPlannerObservable();

        travelPlannerObservable.addObserver(tripObserver);
        travelPlannerObservable.setRouteStrategy(new HistoricalRoute());
        travelPlannerObservable.planRoute();

        // FLYWEIGHT PATTERN
        ParkFlyweightFactory parkFactory = new ParkFlyweightFactory();

        System.out.println("\nEnter park name:");
        String parkName = scanner.next();
        TouristAttractionflyweight park1 = parkFactory.getPark(parkName);
        park1.visit();

        System.out.println("\nEnter another park name:");
        parkName = scanner.next();
        TouristAttractionflyweight park2 = parkFactory.getPark(parkName);
        park2.visit();

        // SINGLETON PATTERN
        ClosingActivity closingActivity1 = ClosingActivity.getInstance();
        ClosingActivity closingActivity2 = ClosingActivity.getInstance();

        System.out.println("Is ClosingActivity singleton instance? " + (closingActivity1 == closingActivity2));

        // ADAPTER PATTERN
        System.out.println("\nEnter payment amount:");
        int paymentAmount = scanner.nextInt();

        PaymentProcessor cashProcessor = new CashPaymentProcessor();
        PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();

        System.out.println("Choose payment method: 1 - Cash, 2 - Credit Card");
        int paymentChoice = scanner.nextInt();

        if (paymentChoice == 1) {
            cashProcessor.pay(paymentAmount);
        } else {
            creditCardProcessor.pay(paymentAmount);
        }

        // FACADE PATTERN
        System.out.println("\nShopping facade:");
        ShoppingFacade shoppingFacade = new ShoppingFacade();
        shoppingFacade.buyClothes();
        shoppingFacade.buySnacks();
        shoppingFacade.buySouvenirs();

        scanner.close();
    }
}
