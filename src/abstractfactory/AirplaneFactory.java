package abstractfactory;

public class AirplaneFactory implements TransportFactory {
        @Override
        public Transport createTransport() {
            return new Airplane() {
            };
        }

}
