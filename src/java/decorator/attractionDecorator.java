package java.decorator;

abstract class attractionDecorator implements touristAttraction {
    protected touristAttraction attraction;

    public attractionDecorator(touristAttraction attraction) {
        this.attraction = attraction;
    }

    public void visit() {
        attraction.visit();
    }
}
