package decorator;

public class AttractionDecorator implements TouristAttraction{
    protected TouristAttraction attraction;

    public AttractionDecorator(TouristAttraction attraction) {
        this.attraction = attraction;
    }

    public void visit() {
        attraction.visit();
    }
}
