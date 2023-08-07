package java.facade;

// Concrete Subsystem Class
public class CashPaymentProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Pembayaran tunai: " + amount);
    }
}
