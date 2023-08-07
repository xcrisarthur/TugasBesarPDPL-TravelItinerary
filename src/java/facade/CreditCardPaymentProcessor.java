package java.facade;

// Concrete Subsystem Class
public class CreditCardPaymentProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Pembayaran dengan kartu kredit: " + amount);
    }
}