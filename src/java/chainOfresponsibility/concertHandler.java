package java.chainOfresponsibility;

class concertHandler implements eveningActivityHandler {
    private eveningActivityHandler next;

    public void setNext(eveningActivityHandler next) {
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
