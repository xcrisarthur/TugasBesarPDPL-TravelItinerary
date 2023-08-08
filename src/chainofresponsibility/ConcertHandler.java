package chainofresponsibility;

public class ConcertHandler implements EveningActivityHandler {
    private EveningActivityHandler nextHandler;

    @Override
    public void setNext(EveningActivityHandler handler) {
        nextHandler = handler;
    }

    @Override
    public void handleActivity(String activity) {
        if (activity.equalsIgnoreCase("concert")) {
            System.out.println("Menghadiri konser musik.");
        } else if (nextHandler != null) {
            nextHandler.handleActivity(activity);
        } else {
            System.out.println("Tidak ada aktivitas malam yang sesuai.");
        }
    }
}
