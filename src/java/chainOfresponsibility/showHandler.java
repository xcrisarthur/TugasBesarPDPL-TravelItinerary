package java.chainOfresponsibility;

class ShowHandler implements EveningActivityHandler {
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
            }
        }
    }
}