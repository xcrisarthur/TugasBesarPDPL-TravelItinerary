package java.decorator;

class tourGuideDecorator extends attractionDecorator {
    public tourGuideDecorator(touristAttraction attraction) {
        super(attraction);
    }

    public void visit() {
        super.visit();
        System.out.println("Menggunakan pemandu wisata.");
    }
}