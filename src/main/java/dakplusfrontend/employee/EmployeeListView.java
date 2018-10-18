package dakplusfrontend.employee;

import dakplusbackend.ServiceBinder;
import dakplusbackend.model.Employee;
import dakplusbackend.service.EmployeeService;
import dakplusfrontend.alert.AlertBuilder;
import dakplusfrontend.event.DPPEventbus;
import dakplusfrontend.event.EditEmployeeEvent;
import javafx.collections.FXCollections;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListView extends Panel {
    private final EmployeeService employeeService;
    private final ListView<Employee> employeeListView;

    private final TextField nameField;
    private String nameToSearch = new String();
    private boolean activeContractOnly;

    public EmployeeListView() {
        this.employeeService = ServiceBinder.binder().getService(EmployeeService.class);

        this.getStyleClass().add("panel-default");
        this.setWidth(Double.MAX_VALUE);

        Label header = new Label("Employees");
        header.getStyleClass().add("h3");
        setHeading(header);

        HBox searchBar = new HBox();
        searchBar.setSpacing(4);

        nameField = new TextField();
        nameField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {if (event.getCode().equals(KeyCode.ENTER)) updateSearchName();});
        Button buttonSearchByName = new Button("Search");
        buttonSearchByName.setOnMouseClicked(event -> updateSearchName());
        ToggleButton activeContractOnly = new ToggleButton("Active Contract");
        activeContractOnly.selectedProperty().addListener((observable, oldValue, newValue) -> updateActiveContractParam(newValue));

        searchBar.getChildren().addAll(nameField, buttonSearchByName, activeContractOnly);

        VBox vbox = new VBox();
        vbox.setSpacing(4);

        employeeListView = new ListView<>();
        try {
            employeeListView.setItems(FXCollections.observableArrayList(employeeService.getAllEmployees()));
        } catch (SQLException e) {
            AlertBuilder.createSQLErrorAlert(e);
            e.printStackTrace();
        }

        employeeListView.setOnMouseClicked(event -> employeeClicked(event));

        vbox.getChildren().addAll(searchBar, employeeListView);
        this.setBody(vbox);
    }

    private void updateSearchName() {
        nameToSearch = nameField.getText();
        updateListView();
    }

    private void updateActiveContractParam(Boolean newValue) {
        this.activeContractOnly = newValue;
        updateListView();
    }

    private void updateListView() {
        try {
            List<Employee> newList = null;
            if (this.activeContractOnly && nameToSearch != null && !nameToSearch.isEmpty())
                newList = employeeService.getAllEmployeeWithActiveContractAndNameContaining(nameToSearch);
            else if (this.activeContractOnly) newList = employeeService.getAllEmployeeWithActiveContract();
            else if (this.nameToSearch != null && !nameToSearch.isEmpty())
                newList = employeeService.getAllEmployeeByNameContaining(nameToSearch);
            else newList = employeeService.getAllEmployees();

            System.out.println(String.format("Found %d employees", newList.size()));
            employeeListView.setItems(FXCollections.observableArrayList(newList));
        } catch (SQLException e) {
            AlertBuilder.createSQLErrorAlert(e);
            e.printStackTrace();
        }



    }


    private void employeeClicked(MouseEvent event) {
        if (event.getClickCount() > 1) {
            DPPEventbus.fireEvent(new EditEmployeeEvent(employeeListView.getSelectionModel().getSelectedItem()));
        }
    }
}
