package java.factory;

import java.flyweight.TouristAttraction;

class Park implements TouristAttraction {
    public void visit() {
        System.out.println("Mengunjungi taman bermain.");
    }
}
