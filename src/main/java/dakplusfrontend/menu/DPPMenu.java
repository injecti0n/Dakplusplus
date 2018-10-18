package dakplusfrontend.menu;

import dakplusfrontend.event.CreateNewEmployeeEvent;
import dakplusfrontend.event.DPPEventbus;
import dakplusfrontend.event.ListEmployeeEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class DPPMenu extends MenuBar {
    public DPPMenu() {
        MenuItem employeeListItem = new MenuItem("List Employees");
        employeeListItem.setOnAction(event -> DPPEventbus.fireEvent(new ListEmployeeEvent()));

        MenuItem employeeNewItem = new MenuItem("Create employee");
        employeeNewItem.setOnAction(event -> DPPEventbus.fireEvent(new CreateNewEmployeeEvent()));

        Menu employeeMenu = new Menu("Employee");
        employeeMenu.getItems().addAll(employeeListItem, employeeNewItem);

        Menu projectMenu = new Menu("Project");
        MenuItem projectListItem = new MenuItem("Show Projects");
        MenuItem projectNewItem = new MenuItem("Create Project");
        projectMenu.getItems().addAll(projectListItem, projectNewItem);


        this.getMenus().addAll(employeeMenu, projectMenu);



    }
}
