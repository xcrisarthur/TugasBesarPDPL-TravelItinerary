package adapter;

public class CreditCardPaymentProcessor implements PaymentProcessor {
    public void pay(int amount) {
        System.out.println("Pembayaran sebesar Rp" + amount + " dengan kartu kredit.");
    }
}
