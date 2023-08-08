package chainofresponsibility;

public class ShowHandler implements EveningActivityHandler {
    private EveningActivityHandler nextHandler;

    @Override
    public void setNext(EveningActivityHandler handler) {
        nextHandler = handler;
    }

    @Override
    public void handleActivity(String activity) {
        if (activity.equalsIgnoreCase("show")) {
            System.out.println("Menyaksikan pertunjukan.");
        } else if (nextHandler != null) {
            nextHandler.handleActivity(activity);
        } else {
            System.out.println("Tidak ada aktivitas malam yang sesuai.");
        }
    }
}