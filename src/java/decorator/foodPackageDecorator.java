package java.decorator;

class foodPackageDecorator extends attractionDecorator {
    public foodPackageDecorator(touristAttraction attraction) {
        super(attraction);
    }

    public void visit() {
        super.visit();
        System.out.println("Termasuk paket makanan.");
    }
}