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

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        welcomeMessage();
        transportSection(scanner);
        strategySection(scanner);
        attractionSection(scanner);
        eveningActivitySection(scanner);
        observerSection(scanner);
        flyweightSection(scanner);
        singletonSection();
        adapterSection(scanner);
        shoppingSection(scanner);
        scanner.close();
    }

    private static void welcomeMessage() {
        WelcomeMessage.main(new String[0]);
    }

    private static void transportSection(Scanner scanner) {
        TransportFactoryManager factoryManager = new TransportFactoryManager();
        factoryManager.registerTransportFactory(1, new CarFactory());
        factoryManager.registerTransportFactory(2, new AirplaneFactory());

        System.out.println("=====================================");
        System.out.println("||                                 ||");
        System.out.println("||   Pilih moda transportasi :     ||");
        System.out.println("||                                 ||");
        System.out.println("||   1. Mobil                      ||");
        System.out.println("||   2. Pesawat                    ||");
        System.out.println("||                                 ||");
        System.out.println("=====================================");

        System.out.print("Masukkan pilihan : ");
        int transportChoice = scanner.nextInt();

        TransportFactory transportFactory = factoryManager.getTransportFactory(transportChoice);
        if (transportFactory != null) {
            Transport transport = transportFactory.createTransport();
            System.out.println("Perjalanan dimulai...");
            transport.travel();
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }


    private static void strategySection(Scanner scanner) {
        TravelPlanner travelPlanner = new TravelPlanner();

        System.out.println("=====================================");
        System.out.println("||                                 ||");
        System.out.println("||   Pilih rute perjalanan :       ||");
        System.out.println("||                                 ||");
        System.out.println("||   1. Bersejarah                 ||");
        System.out.println("||   2. Alam dan Olahraga          ||");
        System.out.println("||                                 ||");
        System.out.println("=====================================");

        System.out.print("Masukkan pilihan Anda: ");
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
    }


    private static void attractionSection(Scanner scanner) {
        System.out.println("=================================");
        System.out.println("||                             ||");
        System.out.println("||   Pilih objek wisata :      ||");
        System.out.println("||                             ||");
        System.out.println("||   1. Taman Bermain          ||");
        System.out.println("||   2. Museum                 ||");
        System.out.println("||                             ||");
        System.out.println("=================================");

        System.out.print("Masukkan pilihan Anda: ");
        int attractionChoice = scanner.nextInt();

        Attraction attraction = AttractionFactory.createAttraction(attractionChoice);
        if (attraction != null) {
            attraction.visit();
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }
    }


    private static void eveningActivitySection(Scanner scanner) {
        EveningActivityHandler eveningActivityHandler = new ShowHandler();
        EveningActivityHandler concertHandler = new ConcertHandler();

        eveningActivityHandler.setNext(concertHandler);

        System.out.println("=====================================");
        System.out.println("||                                 ||");
        System.out.println("||   Pilih aktivitas malam :       ||");
        System.out.println("||                                 ||");
        System.out.println("||   1. Pertunjukan                ||");
        System.out.println("||   2. Konser                    ||");
        System.out.println("||   3. Kegiatan lain             ||");
        System.out.println("||                                 ||");
        System.out.println("=====================================");

        System.out.print("Masukkan pilihan Anda: ");
        int eveningActivityChoice = scanner.nextInt();

        if (eveningActivityChoice == 1) {
            eveningActivityHandler.handleActivity("show");
        } else if (eveningActivityChoice == 2) {
            eveningActivityHandler.handleActivity("concert");
        } else {
            eveningActivityHandler.handleActivity("other");
        }
    }

    private static void observerSection(Scanner scanner) {
        TripObserver tripObserver = new TripObserver();
        TravelPlannerObservable travelPlannerObservable = new TravelPlannerObservable();

        travelPlannerObservable.addObserver(tripObserver);

        System.out.println("===========================================");
        System.out.println("||                                       ||");
        System.out.println("||   Pilih rute perjalanan :             ||");
        System.out.println("||                                       ||");
        System.out.println("||   1. Bersejarah                       ||");
        System.out.println("||   2. Alam dan Olahraga                ||");
        System.out.println("||   3. Rute lain                        ||");
        System.out.println("||                                       ||");
        System.out.println("===========================================");

        System.out.print("Masukkan pilihan Anda: ");
        int observerRouteChoice = scanner.nextInt();

        RouteStrategy routeStrategy1 = RouteStrategyFactory.createRouteStrategy(observerRouteChoice);
        travelPlannerObservable.setRouteStrategy(routeStrategy1);

        System.out.println("Perencanaan rute perjalanan:");
        travelPlannerObservable.planRoute();
    }

    private static void flyweightSection(Scanner scanner) {
        ParkFactory parkFactory = new ParkFactory();

        System.out.println("=====================================");
        System.out.println("||                                 ||");
        System.out.println("||   Pilih taman untuk dikunjungi :||");
        System.out.println("||                                 ||");
        System.out.println("||   1. Taman Lalu Lintas          ||");
        System.out.println("||   2. Taman Kartini              ||");
        System.out.println("||                                 ||");
        System.out.println("=====================================");

        System.out.print("Masukkan pilihan Anda: ");
        int parkChoice = scanner.nextInt();
        if (parkChoice == 1) {
            TouristAttractionflyweight park1 = parkFactory.getPark("Park Lalu Lintas");
            park1.visit();
        } else if (parkChoice == 2) {
            TouristAttractionflyweight park2 = parkFactory.getPark("Park Kartini");
            park2.visit();
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            return;
        }
    }

    private static void singletonSection() {
        ClosingActivity closingActivity1 = ClosingActivity.getInstance();
        ClosingActivity closingActivity2 = ClosingActivity.getInstance();

        // Check if closingActivity1 and closingActivity2 are the same instance
        boolean areInstancesEqual = (closingActivity1 == closingActivity2);
        System.out.println("Apakah "+ closingActivity1 +" sama dengan "+ closingActivity2 +"? Adalah " + areInstancesEqual);
    }

    private static void adapterSection(Scanner scanner) {
        System.out.println("=====================================");
        System.out.println("||                                 ||");
        System.out.println("||   Pilih metode pembayaran :     ||");
        System.out.println("||                                 ||");
        System.out.println("||   1. Uang tunai                 ||");
        System.out.println("||   2. Kartu kredit               ||");
        System.out.println("||                                 ||");
        System.out.println("=====================================");

        System.out.print("Masukkan pilihan Anda: ");
        int paymentChoice = scanner.nextInt();
        PaymentProcessor paymentProcessor = PaymentProcessorFactory.createPaymentProcessor(paymentChoice);

        if (paymentProcessor != null) {
            System.out.println("Masukkan jumlah pembayaran:");
            int paymentAmount = scanner.nextInt();
            paymentProcessor.pay(paymentAmount);
        } else {
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    private static void shoppingSection(Scanner scanner) {
        System.out.println("=====================================");
        System.out.println("||                                 ||");
        System.out.println("||   Ingin berbelanja?             ||");
        System.out.println("||                                 ||");
        System.out.println("||   (y) Ya                        ||");
        System.out.println("||   (n) Tidak                     ||");
        System.out.println("||                                 ||");
        System.out.println("=====================================");

        System.out.print("Masukkan pilihan Anda (y/n): ");
        String shopChoice = scanner.next();
        if (shopChoice.equalsIgnoreCase("y")) {
            ShoppingFacade shoppingFacade = new ShoppingFacade();
            shoppingFacade.buyClothes();
            shoppingFacade.buySnacks();
            shoppingFacade.buySouvenirs();
        }

        System.out.println("Terima kasih telah menggunakan Aplikasi Perjalanan!");
    }
}
