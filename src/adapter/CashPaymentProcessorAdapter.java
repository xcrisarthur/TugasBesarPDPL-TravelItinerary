package adapter;

public class CashPaymentProcessorAdapter implements PaymentProcessorAdapter {
    private CashPaymentProcessor cashProcessor;

    public CashPaymentProcessorAdapter(CashPaymentProcessor cashProcessor) {
        this.cashProcessor = cashProcessor;
    }

    public void processPayment(int amount) {
        cashProcessor.pay(amount);
    }
}
