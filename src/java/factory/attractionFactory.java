package java.factory;

class AttractionFactory {
    public static TouristAttraction createAttraction(String type) {
        if (type.equalsIgnoreCase("museum")) {
            return new Museum();
        } else if (type.equalsIgnoreCase("park")) {
            return new Park();
        } else {
            throw new IllegalArgumentException("Invalid attraction type.");
        }
    }
}