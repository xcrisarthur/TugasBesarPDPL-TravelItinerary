package java.facade;

// Facade Class
public class ShoppingFacade {
    private Store store;
    private PaymentProcessor paymentProcessor;

    public ShoppingFacade() {
        store = new Store();
        paymentProcessor = new CreditCardPaymentProcessor();
    }

    public void buySouvenirs() {
        store.selectItems("Souvenir items");
        paymentProcessor.pay(100.0);
        store.wrapItems();
    }

    public void buyClothes() {
        store.selectItems("Clothes");
        paymentProcessor.pay(200.0);
        store.wrapItems();
    }

    public void buySnacks() {
        store.selectItems("Snacks");
        paymentProcessor.pay(50.0);
        store.wrapItems();
    }
}
