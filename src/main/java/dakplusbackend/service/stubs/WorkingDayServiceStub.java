package dakplusbackend.service.stubs;

import dakplusbackend.model.Employee;
import dakplusbackend.model.WorkingDay;
import dakplusbackend.service.WorkingDayService;

import java.sql.SQLException;

// TODO
public class WorkingDayServiceStub implements WorkingDayService {
    @Override
    public WorkingDay addWorkingdayToEmployee(Employee employee, WorkingDay workingDay) throws SQLException, IllegalArgumentException {
        return null;
    }

    @Override
    public WorkingDay saveWorkday(WorkingDay day) {
        return null;
    }
}
