package java.chainOfresponsibility;

class ConcertHandler implements EveningActivityHandler {
    private EveningActivityHandler next;

    public void setNext(EveningActivityHandler next) {
        this.next = next;
    }

    public void handleActivity(String activity) {
        if (activity.equalsIgnoreCase("concert")) {
            System.out.println("Menghadiri konser musik.");
        } else {
            if (next != null) {
                next.handleActivity(activity);
            }
        }
    }
}
