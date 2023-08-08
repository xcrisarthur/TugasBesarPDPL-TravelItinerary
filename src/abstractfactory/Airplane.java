package abstractfactory;

public class    Airplane implements Transport  {
    @Override
    public void travel() {
        System.out.println("Perjalanan menggunakan pesawat.");
    }
}
