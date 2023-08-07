package java.facade;

// Subsystem Class
public class Store {
    public void selectItems(String items) {
        System.out.println("Memilih barang: " + items);
    }

    public void doPayment(double amount) {
        System.out.println("Melakukan pembayaran: " + amount);
    }

    public void wrapItems() {
        System.out.println("Membungkus barang.");
    }
}
