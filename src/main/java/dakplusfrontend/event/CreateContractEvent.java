package dakplusfrontend.event;

import dakplusbackend.model.Employee;
import javafx.event.ActionEvent;

public class CreateContractEvent extends ActionEvent {
    private final Employee employee;

    public CreateContractEvent(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
