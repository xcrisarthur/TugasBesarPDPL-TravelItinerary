package flyweight;

import java.util.HashMap;
import java.util.Map;

public class ParkFlyweightFactory {
    private Map<String, TouristAttractionflyweight> parks = new HashMap<>();

    public TouristAttractionflyweight getPark(String name) {
        TouristAttractionflyweight park = parks.get(name);

        if (park == null) {
            park = new Park(name);
            parks.put(name, park);
        }

        return park;
    }
}
