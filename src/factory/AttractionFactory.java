package factory;

import decorator.Museum;
import decorator.TouristAttraction;

public class AttractionFactory {
    public static Attraction createAttraction(String type) {
        if (type.equalsIgnoreCase("museum")) {
            return new MuseumAttraction();
        } else if (type.equalsIgnoreCase("park")) {
            return new ParkAttraction();
        } else {
            throw new IllegalArgumentException("Invalid attraction type.");
        }
    }
}
