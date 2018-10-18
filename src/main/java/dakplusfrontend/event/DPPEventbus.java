package dakplusfrontend.event;

import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class DPPEventbus {
    private static List<Subscriber> subscribers = new ArrayList<>();
    public static void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public static void fireEvent(ActionEvent event) {
        System.out.println("Received event... publishing");
        subscribers.stream().forEach(subscriber -> subscriber.handleEvent(event));
    }
}
