package java.abstractFactory;

class carFactory implements transportFactory {
    public Transport createTransport() {
        return new Car();
    }
}
