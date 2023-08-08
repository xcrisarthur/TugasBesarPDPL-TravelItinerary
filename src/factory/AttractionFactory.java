package factory;

import decorator.Museum;
import decorator.TouristAttraction;
import flyweight.Park;

public class AttractionFactory {
    public static Attraction createAttraction(int attractionChoice) {
        switch (attractionChoice) {
            case 1:
                return new ParkAttraction();
            case 2:
                return new MuseumAttraction();
            // Tambahkan kasus untuk objek wisata baru jika diperlukan
            default:
                return null;
        }
    }
}


