package java.chainOfresponsibility;

class showHandler implements eveningActivityHandler {
    private eveningActivityHandler next;

    public void setNext(eveningActivityHandler next) {
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