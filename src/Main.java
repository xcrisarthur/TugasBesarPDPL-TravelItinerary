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

public class Main {
    public static void main(String[] args) {
        // ABSTRACT FACTORY PATTERN
        TransportFactory carFactory = new CarFactory();
        Transport car = carFactory.createTransport();
        car.travel();

        TransportFactory airplaneFactory = new AirplaneFactory();
        Transport airplane = airplaneFactory.createTransport();
        airplane.travel();

        // STRATEGY PATTERN
        TravelPlanner travelPlanner = new TravelPlanner();

        travelPlanner.setRouteStrategy(new HistoricalRoute());
        travelPlanner.planRoute();

        travelPlanner.setRouteStrategy(new NatureAndSportsRoute());
        travelPlanner.planRoute();

        // DECORATOR PATTERN
        TouristAttraction museum = new Museum();
        TouristAttraction museumWithGuide = new TourGuideDecorator(museum);
        TouristAttraction museumWithGuideAndFood = new FoodPackageDecorator(museumWithGuide);

        museum.visit();
        museumWithGuide.visit();
        museumWithGuideAndFood.visit();

        // FACTORY PATTERN
        AttractionFactory attractionFactory = new AttractionFactory();
        Attraction park = attractionFactory.createAttraction("park");
        Attraction museumAttraction = attractionFactory.createAttraction("museum");

        park.visit();
        museumAttraction.visit();

        // CHAIN OF RESPONSIBILITY PATTERN
        EveningActivityHandler eveningActivityHandler = new ShowHandler();
        EveningActivityHandler concertHandler = new ConcertHandler();

        eveningActivityHandler.setNext(concertHandler);

        eveningActivityHandler.handleActivity("show");
        eveningActivityHandler.handleActivity("concert");
        eveningActivityHandler.handleActivity("movie"); // Default handler

        // OBSERVER PATTERN
        TripObserver tripObserver = new TripObserver();
        TravelPlannerObservable travelPlannerObservable = new TravelPlannerObservable();

        travelPlannerObservable.addObserver(tripObserver);
        travelPlannerObservable.setRouteStrategy(new HistoricalRoute());
        travelPlannerObservable.planRoute();

        // FLYWEIGHT PATTERN
        ParkFlyweightFactory parkFactory = new ParkFlyweightFactory();

        TouristAttractionflyweight park1 = parkFactory.getPark("Park A");
        park1.visit();

        TouristAttractionflyweight park2 = parkFactory.getPark("Park A");
        park2.visit(); // Park A object is reused, not created again

        TouristAttractionflyweight park3 = parkFactory.getPark("Park B");
        park3.visit();

        // SINGLETON PATTERN
        ClosingActivity closingActivity1 = ClosingActivity.getInstance();
        ClosingActivity closingActivity2 = ClosingActivity.getInstance();

        System.out.println(closingActivity1 == closingActivity2); // Should be true, same instance

        // ADAPTER PATTERN
        PaymentProcessor cashProcessor = new CashPaymentProcessor();
        cashProcessor.pay(100);

        PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();
        creditCardProcessor.pay(200);

        // FACADE PATTERN
        ShoppingFacade shoppingFacade = new ShoppingFacade();
        shoppingFacade.buyClothes();
        shoppingFacade.buySnacks();
        shoppingFacade.buySouvenirs();
    }
}
