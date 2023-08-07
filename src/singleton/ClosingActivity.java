package singleton;

public class ClosingActivity {
    private static ClosingActivity instance;

    // Private constructor to prevent instantiation from other classes
    private ClosingActivity() {}

    // Public method to get the singleton instance
    public static ClosingActivity getInstance() {
        if (instance == null) {
            synchronized (ClosingActivity.class) {
                if (instance == null) {
                    instance = new ClosingActivity();
                }
            }
        }
        return instance;
    }

    public void performClosingActivity() {
        System.out.println("Closing activity is being performed.");
    }
}
