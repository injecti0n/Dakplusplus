package dakplusbackend.service;

import dakplusbackend.model.Employee;
import dakplusbackend.model.WorkingDay;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public interface EmployeeService {
    /**
     * Find all {@link Employee}
     *
     * @return a List of all {@link Employee} found in the database
     */
    List<Employee> getAllEmployees() throws SQLException;

    /**
     * Find all {@link Employee} for whom the first- or lastname contains the given String
     *
     * @param name the subString filter
     * @return a filtered List of all {@link Employee}
     */
    List<Employee> getAllEmployeeByNameContaining(String name) throws SQLException;

    /**
     * Find all employees that have a {@link dakplusbackend.model.Contract Contract} without end date
     * @return a filtered List of all {@link Employee}
     */
    List<Employee> getAllEmployeeWithActiveContract() throws SQLException;

    /**
     * Find all employees that have an active {@link dakplusbackend.model.Contract Contract} and with a first- or last
     * name containing the provided String
     * @param name the substring filter
     * @return a filter List of all {@link Employee}
     * @throws SQLException When something goes wrong..
     */
    List<Employee> getAllEmployeeWithActiveContractAndNameContaining(String name) throws SQLException;

    /**
     * The {@link #getEmployee(Long)} method will retrieve an Employee object from the database using the PK
     * <p>
     * @param id The PK for {@link Employee}
     * @return An Employee instance
     * @throws NoSuchElementException If the PK was invalid (did not exist in de database)
     */
    Employee getEmployee(Long id) throws NoSuchElementException;

    /**
     * The {@link #getEmployee(Long)} method queries the database for the employee
     * in order to reset the data to an unedited state.
     * <p>
     * @param employee The employee that needs to be refreshed
     * @return an {@link Employee} object with internal state corresponding to the database state.
     * @throws SQLException In case there is a problem with the connection or the query
     * @throws NoSuchElementException In case the requested employee has no ID or the employee can not be found in the database.
     */
    Employee refreshEmployee(Employee employee) throws SQLException, NoSuchElementException;
    /**
     * Saves the employee to the database. Existing and new {@link Employee}
     *
     * @param employee The {@link Employee} object to be saved
     * @return The {@link Employee} object that can be found in the database.
     */
    Employee saveEmployee(Employee employee) throws SQLException;

    /**
     * Removes an {@link Employee} from the database.
     *
     * @param employee The employee object that needs to be deleted.
     */
    void deleteEmployee(Employee employee) throws SQLException;

    /**
     * Removes the {@link Employee} from the database.
     *
     * @param idEmployee The id of the employee that needs to be deleted.
     */
    void deleteEmployee(Long idEmployee) throws SQLException;

    /**
     * TODO
     * @param employee
     * @param workingDay
     * @return
     */

    WorkingDay addWorkdayToEmployee(Employee employee, WorkingDay workingDay);
}
