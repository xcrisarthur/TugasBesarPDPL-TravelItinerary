package java.flyweight;

public class Park implements TouristAttraction {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public void visit() {
        System.out.println("Mengunjungi taman bermain " + name + ".");
    }
}