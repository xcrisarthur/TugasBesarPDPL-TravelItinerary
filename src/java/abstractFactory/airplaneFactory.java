package java.abstractFactory;

class AirplaneFactory implements TransportFactory {
    public Transport createTransport() {
        return new Airplane();
    }
}
