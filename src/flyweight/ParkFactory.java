package flyweight;

import java.util.HashMap;
import java.util.Map;

public class ParkFactory {
    private Map<String, TouristAttractionflyweight> parks = new HashMap<>();

    public TouristAttractionflyweight getPark(String parkName) {
        TouristAttractionflyweight park = parks.get(parkName);
        if (park == null) {
            park = new Park(parkName);
            parks.put(parkName, park);
        }
        return park;
    }
}
