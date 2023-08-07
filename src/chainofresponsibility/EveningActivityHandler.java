package chainofresponsibility;

public interface EveningActivityHandler {
    void setNext(EveningActivityHandler next);

    void handleActivity(String activity);
}
