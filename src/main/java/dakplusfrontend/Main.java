package dakplusfrontend;

import dakplusbackend.model.Employee;
import dakplusfrontend.contract.ContractView;
import dakplusfrontend.employee.EmployeeEditView;
import dakplusfrontend.employee.EmployeeListView;
import dakplusfrontend.event.*;
import dakplusfrontend.menu.DPPMenu;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application implements Subscriber {
    public static void main(String[] args) {
        launch(args);
    }

    private BorderPane pane;

    public void start(Stage primaryStage) throws Exception {


        pane = new BorderPane();
        MenuBar menuBar = new DPPMenu();
        pane.topProperty().set(menuBar);

        primaryStage.setTitle("Dakplusplus Administration");
        Scene scene = new Scene(pane, 800, 600);
        scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        DPPEventbus.subscribe(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stopping application");
    }

    @Override
    public void handleEvent(ActionEvent event) {
        if (event instanceof CreateNewEmployeeEvent) pane.setCenter(new EmployeeEditView(new Employee()));
        if (event instanceof ListEmployeeEvent) pane.setCenter(new EmployeeListView());
        if (event instanceof EditEmployeeEvent) pane.setCenter(new EmployeeEditView(((EditEmployeeEvent)event).getEmployee()));
        if (event instanceof CreateContractEvent) pane.setCenter(new ContractView(((CreateContractEvent)event).getEmployee().getContract()));
    }
}
