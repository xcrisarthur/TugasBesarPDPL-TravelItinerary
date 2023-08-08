package flyweight;

public class Park implements TouristAttractionflyweight {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    @Override
    public void visit() {
        System.out.println("Mengunjungi taman " + name + ".");
    }
}

