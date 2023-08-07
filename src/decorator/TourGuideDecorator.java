package decorator;

public class TourGuideDecorator extends AttractionDecorator{
    public TourGuideDecorator(TouristAttraction attraction) {
        super(attraction);
    }

    public void visit() {
        super.visit();
        System.out.println("Menggunakan pemandu wisata.");
    }
}
