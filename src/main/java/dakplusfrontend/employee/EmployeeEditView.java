package dakplusfrontend.employee;

import dakplusbackend.ServiceBinder;
import dakplusbackend.model.Contract;
import dakplusbackend.model.Employee;
import dakplusbackend.service.EmployeeService;
import dakplusfrontend.alert.AlertBuilder;
import dakplusfrontend.event.CreateContractEvent;
import dakplusfrontend.event.DPPEventbus;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import java.sql.SQLException;
import java.util.Optional;

public class EmployeeEditView extends Panel {
    private Employee currentEmployee;

    private final TextField firstNameField;
    private final TextField lastNameField;
    private final DatePicker birthDayPicker;

    private final EmployeeService employeeService;

    public EmployeeEditView(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Employee can not be null");
        currentEmployee = employee;
        employeeService = ServiceBinder.binder().getService(EmployeeService.class);

        this.getStyleClass().add("panel-default");

        // Heading
        Label header;
        if (employee.getId() == null)
            header = new Label("Create new Employee");
        else
            header = new Label(String.format("Employee: %d", employee.getId()));
        header.getStyleClass().add("h3");
        setHeading(header);

        // Body
        GridPane pane = new GridPane();

        pane.setAlignment(Pos.TOP_CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));


        firstNameField = new TextField();
        pane.add(new Text("First Name:"), 0, 0);
        pane.add(firstNameField, 1, 0);

        lastNameField = new TextField();
        pane.add(new Text("Last Name:"), 0, 1);
        pane.add(lastNameField, 1, 1);

        birthDayPicker = new DatePicker();
        pane.add(new Text("Birthday:"), 0, 2);
        pane.add(birthDayPicker, 1, 2);

        // Les Buttons
        Button saveButton = new Button("Save");
        saveButton.getStyleClass().add("btn-primary");
        saveButton.setMaxWidth(Double.MAX_VALUE);
        saveButton.setOnMouseClicked(event -> saveEmployee());
        pane.add(saveButton, 0, 3, 2, 1);

        Button addContractButton = new Button("Contract");
        addContractButton.getStyleClass().add("btn-default");
        addContractButton.setOnMouseClicked(event -> openContract());
        addContractButton.setMaxWidth(Double.MAX_VALUE);
        pane.add(addContractButton, 0, 4, 2, 1);

        if (employee.getId() != null) {
            Button resetButton = new Button("Reset");
            resetButton.getStyleClass().add("btn-warning");
            resetButton.setOnMouseClicked(event -> readEmployee());
            resetButton.setMaxWidth(Double.MAX_VALUE);
            pane.add(resetButton, 0, 5, 2, 1);
        }

        readEmployee();
        setBody(pane);
    }

    private void openContract() {
        if (currentEmployee.getId() == null) {
            AlertBuilder.builder()
                    .setType(Alert.AlertType.WARNING)
                    .setTitle("WTF")
                    .setContent("Save the employee before adding a contract")
                    .show();
            return;
        }

        if (currentEmployee.getContract() == null) {
            ButtonType addButton = new ButtonType("Add");
            ButtonType cancelButton = new ButtonType("Cancel");

            Optional<ButtonType> result = AlertBuilder.builder()
                    .setType(Alert.AlertType.INFORMATION)
                    .setTitle("No contract found")
                    .setContent("Do you want to add a new contract?")
                    .setButtonTypes(addButton, cancelButton)
                    .showAndWait();

            if (result.isPresent()) {
                if (result.get() == addButton) {
                    currentEmployee.setContract(new Contract(currentEmployee));
                    DPPEventbus.fireEvent(new CreateContractEvent(currentEmployee));
                }
                if (result.get() == cancelButton) return;
            }
        } else {
            DPPEventbus.fireEvent(new CreateContractEvent(currentEmployee));
        }
    }

    private void readEmployee() {
        

        firstNameField.setText(currentEmployee.getFirstName());
        lastNameField.setText(currentEmployee.getLastName());
        birthDayPicker.setValue(currentEmployee.getBirthDay());
    }

    private void saveEmployee() {
        currentEmployee.setFirstName(firstNameField.getText());
        currentEmployee.setLastName(lastNameField.getText());
        currentEmployee.setBirthDay(birthDayPicker.getValue());

        try {
            currentEmployee = employeeService.saveEmployee(currentEmployee);
        } catch (SQLException e) {
            AlertBuilder.createSQLErrorAlert(e).show();
            e.printStackTrace();
        }
        readEmployee();
    }

}
