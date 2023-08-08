package chainofresponsibility;

public interface EveningActivityHandler {
    void setNext(EveningActivityHandler handler);
    void handleActivity(String activity);
}

