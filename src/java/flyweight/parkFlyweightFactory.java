package java.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
public class ParkFlyweightFactory {
    private Map<String, TouristAttraction> parks = new HashMap<>();

    public TouristAttraction getPark(String name) {
        TouristAttraction park = parks.get(name);

        if (park == null) {
            park = new Park(name);
            parks.put(name, park);
        }

        return park;
    }
}
