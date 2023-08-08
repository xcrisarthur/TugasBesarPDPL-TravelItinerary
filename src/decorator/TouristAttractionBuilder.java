package decorator;

public class TouristAttractionBuilder {
    private TouristAttraction attraction;

    public TouristAttractionBuilder() {
        attraction = new Museum(); // Atau ganti dengan objek wisata default lainnya
    }

    public TouristAttractionBuilder withTourGuide(boolean hasTourGuide) {
        if (hasTourGuide) {
            attraction = new TourGuideDecorator(attraction);
        }
        return this;
    }

    public TouristAttractionBuilder withFoodPackage(boolean hasFoodPackage) {
        if (hasFoodPackage) {
            attraction = new FoodPackageDecorator(attraction);
        }
        return this;
    }

    public TouristAttraction build() {
        return attraction;
    }
}

