package dakplusfrontend.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.SQLException;
import java.util.Optional;

public class AlertBuilder {
    public static Alert createSQLErrorAlert(SQLException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Shit went wrong yo'");
        alert.setContentText(e.getMessage());

        return alert;
    }

    public static AlertBuilder builder() {
        return new AlertBuilder();
    }

    private Alert alert = new Alert(Alert.AlertType.NONE);

    public Alert build() {
        return alert;
    }

    public void show() {
        alert.show();
    }

    public Optional<ButtonType> showAndWait() {
        return alert.showAndWait();
    }

    public AlertBuilder setType(Alert.AlertType type) {
        alert.setAlertType(type);
        return this;
    }

    public AlertBuilder setTitle(String title) {
        alert.setTitle(title);
        return this;
    }

    public AlertBuilder setHeader(String header) {
        alert.setHeaderText(header);
        return this;
    }

    public AlertBuilder setContent(String content) {
        alert.setContentText(content);
        return this;
    }

    public AlertBuilder setButtonTypes(ButtonType... types) {
        alert.getButtonTypes().setAll(types);
        return this;
    }
}
