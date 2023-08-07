package java.abstractFactory;

class CarFactory implements TransportFactory {
    public Transport createTransport() {
        return new Car();
    }
}
