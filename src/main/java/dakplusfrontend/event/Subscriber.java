package dakplusfrontend.event;

import javafx.event.ActionEvent;

public interface Subscriber {
    void handleEvent(ActionEvent event);
}
