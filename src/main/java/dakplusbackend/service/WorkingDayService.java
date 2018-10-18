package dakplusbackend.service;

import dakplusbackend.model.Employee;
import dakplusbackend.model.WorkingDay;

import java.sql.SQLException;

public interface WorkingDayService {
    /**
     * Attaches a {@link WorkingDay} object to the given {@link Employee}
     *
     * @param employee an {@link Employee} object
     * @param workingDay a {@link WorkingDay} object
     * @return the {@link WorkingDay} object saved in the database.
     * @throws SQLException If something goes wrong with writing to the database
     * @throws IllegalArgumentException if the {@link WorkingDay} or the {@link Employee} is not valid. An
     * {@link Employee} is not valid when it has not been saved to the database yet.
     */
    WorkingDay addWorkingdayToEmployee(Employee employee, WorkingDay workingDay) throws SQLException, IllegalArgumentException;

    /**
     * Save a {@link WorkingDay} object to the database.
     * @param day A working
     * @return
     */
    WorkingDay saveWorkday(WorkingDay day);
}
