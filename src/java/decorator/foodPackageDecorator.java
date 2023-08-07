package java.decorator;

class FoodPackageDecorator extends AttractionDecorator {
    public FoodPackageDecorator(TouristAttraction attraction) {
        super(attraction);
    }

    public void visit() {
        super.visit();
        System.out.println("Termasuk paket makanan.");
    }
}