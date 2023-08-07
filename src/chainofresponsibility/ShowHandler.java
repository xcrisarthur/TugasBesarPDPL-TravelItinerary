package chainofresponsibility;

public class ShowHandler implements EveningActivityHandler {
    private EveningActivityHandler next;

    public void setNext(EveningActivityHandler next) {
        this.next = next;
    }

    public void handleActivity(String activity) {
        if (activity.equalsIgnoreCase("show")) {
            System.out.println("Menyaksikan pertunjukan.");
        } else {
            if (next != null) {
                next.handleActivity(activity);
            } else {
                System.out.println("Tidak ada kegiatan malam yang sesuai.");
            }
        }
    }
}