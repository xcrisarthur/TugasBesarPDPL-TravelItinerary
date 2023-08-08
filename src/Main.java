import abstractfactory.*;

import adapter.PaymentProcessorFactory;
import decorator.*;
import flyweight.ParkFactory;
import strategy.*;
import factory.Attraction;
import factory.AttractionFactory;
import chainofresponsibility.EveningActivityHandler;
import chainofresponsibility.ShowHandler;
import chainofresponsibility.ConcertHandler;
import observer.TripObserver;
import observer.TravelPlannerObservable;
import flyweight.TouristAttractionflyweight;
import singleton.ClosingActivity;
import adapter.PaymentProcessor;
import facade.ShoppingFacade;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Aplikasi Perjalanan!");

        TransportFactoryManager factoryManager = new TransportFactoryManager();
        factoryManager.registerTransportFactory(1, new CarFactory());
        factoryManager.registerTransportFactory(2, new AirplaneFactory());

        System.out.println("Pilih moda transportasi: (1) Mobil (2) Pesawat");
        int transportChoice = scanner.nextInt();

        TransportFactory transportFactory = factoryManager.getTransportFactory(transportChoice);
        if (transportFactory != null) {
            Transport transport = transportFactory.createTransport();
            System.out.println("Perjalanan dimulai...");
            transport.travel();
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }

        Transport transport = transportFactory.createTransport();
        System.out.println("Perjalanan dimulai...");
        transport.travel();


        // STRATEGY PATTERN
        TravelPlanner travelPlanner = new TravelPlanner();

        System.out.println("Pilih rute perjalanan: (1) Bersejarah (2) Alam dan Olahraga");
        int routeChoice = scanner.nextInt();

        RouteStrategy routeStrategy = RouteStrategyFactory.createRouteStrategy(routeChoice);
        if (routeStrategy != null) {
            travelPlanner.setRouteStrategy(routeStrategy);
            System.out.println("Perencanaan rute perjalanan:");
            travelPlanner.planRoute();
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }

        // DECORATOR PATTERN
        System.out.println("Mengunjungi objek wisata:");
        TouristAttractionBuilder attractionBuilder = new TouristAttractionBuilder();
        TouristAttraction museum = attractionBuilder.build();
        museum.visit();

        System.out.println("Ingin menggunakan pemandu wisata? (y/n)");
        String useTourGuide = scanner.next();
        if (useTourGuide.equalsIgnoreCase("y")) {
            museum = attractionBuilder.withTourGuide(true).build();
            museum.visit();
        }

        System.out.println("Ingin termasuk paket makanan? (y/n)");
        String includeFoodPackage = scanner.next();
        if (includeFoodPackage.equalsIgnoreCase("y")) {
            museum = attractionBuilder.withFoodPackage(true).build();
            museum.visit();
        }

        // FACTORY PATTERN
        System.out.println("Pilih objek wisata: (1) Taman Bermain (2) Museum");
        int attractionChoice = scanner.nextInt();

        Attraction attraction = AttractionFactory.createAttraction(attractionChoice);
        if (attraction != null) {
            System.out.println("Mengunjungi objek wisata:");
            attraction.visit();
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }


        // CHAIN OF RESPONSIBILITY PATTERN
        EveningActivityHandler eveningActivityHandler = new ShowHandler();
        EveningActivityHandler concertHandler = new ConcertHandler();

        eveningActivityHandler.setNext(concertHandler);

        System.out.println("Pilih aktivitas malam: (1) Pertunjukan (2) Konser (3) Kegiatan lain");
        int eveningActivityChoice = scanner.nextInt();
        if (eveningActivityChoice == 1) {
            eveningActivityHandler.handleActivity("show");
        } else if (eveningActivityChoice == 2) {
            eveningActivityHandler.handleActivity("concert");
        } else {
            eveningActivityHandler.handleActivity("other");
        }

        // OBSERVER PATTERN
        TripObserver tripObserver = new TripObserver();
        TravelPlannerObservable travelPlannerObservable = new TravelPlannerObservable();

        travelPlannerObservable.addObserver(tripObserver);

        System.out.println("Pilih rute perjalanan untuk observer:");
        System.out.println("1. Bersejarah");
        System.out.println("2. Alam dan Olahraga");
        System.out.println("3. Rute lain");
        int observerRouteChoice = scanner.nextInt();

        RouteStrategy routeStrategy1 = RouteStrategyFactory.createRouteStrategy(observerRouteChoice);
        travelPlannerObservable.setRouteStrategy(routeStrategy1);

        System.out.println("Perencanaan rute perjalanan untuk observer:");
        travelPlannerObservable.planRoute();


        // FLYWEIGHT PATTERN
        ParkFactory parkFactory = new ParkFactory();

        System.out.println("Pilih taman untuk dikunjungi: (1) Park A (2) Park B");
        int parkChoice = scanner.nextInt();
        if (parkChoice == 1) {
            TouristAttractionflyweight park1 = parkFactory.getPark("Park A");
            park1.visit();
        } else if (parkChoice == 2) {
            TouristAttractionflyweight park2 = parkFactory.getPark("Park B");
            park2.visit();
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }


        // SINGLETON PATTERN
        ClosingActivity closingActivity1 = ClosingActivity.getInstance();
        ClosingActivity closingActivity2 = ClosingActivity.getInstance();

        System.out.println("Apakah ClosingActivity1 sama dengan ClosingActivity2? " + (closingActivity1 == closingActivity2));

        // ADAPTER PATTERN
        System.out.println("Pilih metode pembayaran: (1) Uang tunai (2) Kartu kredit");
        int paymentChoice = scanner.nextInt();
        PaymentProcessor paymentProcessor = PaymentProcessorFactory.createPaymentProcessor(paymentChoice);

        if (paymentProcessor != null) {
            paymentProcessor.pay(200); // Ganti 200 dengan jumlah yang sesuai
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }


        System.out.println("Masukkan jumlah pembayaran:");
        int paymentAmount = scanner.nextInt();
        paymentProcessor.pay(paymentAmount);

        // FACADE PATTERN
        System.out.println("Ingin berbelanja? (y/n)");
        String shopChoice = scanner.next();
        if (shopChoice.equalsIgnoreCase("y")) {
            ShoppingFacade shoppingFacade = new ShoppingFacade();
            shoppingFacade.buyClothes();
            shoppingFacade.buySnacks();
            shoppingFacade.buySouvenirs();
        }

        System.out.println("Terima kasih telah menggunakan Aplikasi Perjalanan!");
        scanner.close();
    }
}
