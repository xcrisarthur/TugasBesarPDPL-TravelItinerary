package adapter;

public class CashPaymentProcessor implements PaymentProcessor {
    public void pay(int amount) {
        System.out.println("Pembayaran sebesar " + amount + " dengan uang tunai.");
    }
}