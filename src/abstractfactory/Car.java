package abstractfactory;

public class Car implements Transport{
    @Override
    public void travel() {
        System.out.println("Perjalanan menggunakan mobil.");
    }
}
