package adapter;

public class CreditCardPaymentProcessorAdapter implements PaymentProcessorAdapter {
    private CreditCardPaymentProcessor creditCardProcessor;

    public CreditCardPaymentProcessorAdapter(CreditCardPaymentProcessor creditCardProcessor) {
        this.creditCardProcessor = creditCardProcessor;
    }

    public void processPayment(int amount) {
        creditCardProcessor.pay(amount);
    }
}
