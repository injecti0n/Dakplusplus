package dakplusfrontend.event;

import dakplusbackend.model.Employee;
import javafx.event.ActionEvent;

public class EditEmployeeEvent extends ActionEvent {
    private Employee employee;

    public EditEmployeeEvent(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
