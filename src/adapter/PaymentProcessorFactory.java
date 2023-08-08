package adapter;

public class PaymentProcessorFactory {
    public static PaymentProcessor createPaymentProcessor(int paymentChoice) {
        switch (paymentChoice) {
            case 1:
                return new CashPaymentProcessor();
            case 2:
                return new CreditCardPaymentProcessor();
            // Tambahkan kasus untuk metode pembayaran baru jika diperlukan
            default:
                return null;
        }
    }
}

