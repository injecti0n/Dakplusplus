package dakplusfrontend.contract;

import dakplusbackend.ServiceBinder;
import dakplusbackend.model.Contract;
import dakplusbackend.model.ContractType;
import dakplusbackend.model.Employee;
import dakplusbackend.service.ContractService;
import dakplusfrontend.alert.AlertBuilder;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import java.math.BigDecimal;

public class ContractView extends Panel {
    private final ContractService contractService;
    private final Contract currentContract;

    private final TextField employeeField;
    private final DatePicker startDatePicker;
    private final DatePicker endDatePicker;
    private final ComboBox<ContractType> contractTypeComboBox;
    private final TextField salaryTextField;

    public ContractView(Contract contract) {
        this.getStyleClass().add("panel-default");

        contractService = ServiceBinder.binder().getService(ContractService.class);
        if (contract.getEmployee() == null) throw new IllegalArgumentException("Employee instance can not be null");
        currentContract = contract;

        Label header = new Label("Editting contract for: " + contract.getEmployee().getId());
        header.getStyleClass().add("h3");
        setHeading(header);

        Employee e = contract.getEmployee();
        employeeField = new TextField(e.getFirstName() + " " + e.getLastName());
        employeeField.setDisable(true);

        startDatePicker = new DatePicker(contract.getStartDate());
        endDatePicker = new DatePicker();
        if (contract.getEndDate() != null) endDatePicker.setValue(contract.getStartDate());
        contractTypeComboBox = new ComboBox<>(FXCollections.observableArrayList(ContractType.values()));
        contractTypeComboBox.setValue(contract.getContractType());
        salaryTextField = new TextField(contract.getSalary().toString());

        GridPane pane = new GridPane();

        pane.setAlignment(Pos.TOP_CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));

        pane.add(new Label("Employee"), 0, 0);
        pane.add(employeeField, 1, 0);
        pane.add(new Label("StartDate"), 0, 1);
        pane.add(startDatePicker, 1, 1);
        pane.add(new Label("EndDate"), 0, 2);
        pane.add(endDatePicker, 1, 2);
        pane.add(new Label("ContractType"), 0, 3);
        pane.add(contractTypeComboBox, 1, 3);
        pane.add(new Label("Salary"), 0, 4);
        pane.add(salaryTextField, 1, 4);

        Button saveButton = new Button("Save Contract");
        saveButton.setMaxWidth(Double.MAX_VALUE);
        saveButton.getStyleClass().add("btn-primary");
        saveButton.setOnMouseClicked(event -> saveContract());
        pane.add(saveButton, 0, 5, 2, 1);

        Button resetButton = new Button("Reset Contract");
        resetButton.setMaxWidth(Double.MAX_VALUE);
        resetButton.getStyleClass().add("btn-warning");
        resetButton.setOnMouseClicked(event -> resetContract());
        pane.add(resetButton, 0, 6, 2, 1);

        setBody(pane);
    }

    private void saveContract() {
        BigDecimal newSalary;
        try {
            newSalary = new BigDecimal(salaryTextField.getText());
        } catch (NumberFormatException e) {
            AlertBuilder.builder()
                    .setType(Alert.AlertType.ERROR)
                    .setTitle("Oh rly?")
                    .setContent("That salary does not look like a valid number")
                    .show();
            return;
        }

        currentContract.setStartDate(startDatePicker.getValue());
        currentContract.setEndDate(endDatePicker.getValue());
        currentContract.setContractType(contractTypeComboBox.getValue());
        currentContract.setSalary(newSalary);

        contractService.saveContract(currentContract);
    }

    private void resetContract() {
        startDatePicker.setValue(currentContract.getStartDate());
        endDatePicker.setValue(currentContract.getEndDate());
        contractTypeComboBox.setValue(currentContract.getContractType());
        salaryTextField.setText(currentContract.getSalary().toString());
    }
}
