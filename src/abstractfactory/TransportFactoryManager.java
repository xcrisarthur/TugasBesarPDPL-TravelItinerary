package abstractfactory;

import java.util.HashMap;
import java.util.Map;

public class TransportFactoryManager {
    private Map<Integer, TransportFactory> transportFactories = new HashMap<>();

    public void registerTransportFactory(int transportChoice, TransportFactory factory) {
        transportFactories.put(transportChoice, factory);
    }

    public TransportFactory getTransportFactory(int transportChoice) {
        return transportFactories.get(transportChoice);
    }
}
