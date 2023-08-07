package java.abstractFactory;

class airplaneFactory implements transportFactory {
    public Transport createTransport() {
        return new Airplane();
    }
}
