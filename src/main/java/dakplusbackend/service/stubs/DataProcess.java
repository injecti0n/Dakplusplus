package dakplusbackend.service.stubs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dakplusbackend.model.Contract;
import dakplusbackend.model.Employee;
import dakplusbackend.model.WorkingDay;
import dakplusbackend.service.EmployeeService;
import dakplusbackend.model.*;
public class DataProcess implements EmployeeService{
    private List<Employee> employees = new ArrayList<>();
    private List<Contract> contracts = new ArrayList<>();

    public DataProcess() {
     //   if (employees.size() == 0) initData();
    }

    protected List<Contract> getContracts() {
        return contracts;
    }
    
	
	private List<Employee> RetrieveData(ResultSet rs) throws SQLException {
        List<Employee> resultList = new ArrayList<>();

        while (rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getLong("idemployees"));
            emp.setFirstName(rs.getString("firstName"));
            emp.setLastName(rs.getString("lastName"));
            emp.setBirthDay((rs.getDate("birthDay").toLocalDate()));
            

            resultList.add(emp);
        }

        return resultList;
    }

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		String sql = String.format("SELECT * FROM employees");
		Employee e = new Employee();
        ResultSet rs = SendSQLServer(sql);
        List<Employee> employees = RetrieveData(rs);
        employees.add(e);

        return employees;
	}

	@Override
	public List<Employee> getAllEmployeeByNameContaining(String name) throws SQLException {
		String sql = String.format("SELECT * FROM employees WHERE firstName LIKE '%%%s%%'", name);
		Employee e = new Employee();
        ResultSet rs = SendSQLServer(sql);
        List<Employee> employees = RetrieveData(rs);
        employees.add(e);

        return employees;
	}

	@Override
	public List<Employee> getAllEmployeeWithActiveContract() throws SQLException {
		String sql = String.format("SELECT * FROM employees WHERE ContractType = 'FULLTIME' OR ContractType = 'FIXEDTIME' OR ContractType = 'PARTTIME'");
		// SELECT * FROM employees WHERE ContractType IS NOT NULL;
		Employee e = new Employee();
        ResultSet rs = SendSQLServer(sql);
        List<Employee> employees = RetrieveData(rs);
        employees.add(e);

        return employees;
	}

	@Override
	public List<Employee> getAllEmployeeWithActiveContractAndNameContaining(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(Long id) throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee refreshEmployee(Employee employee) throws SQLException, NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee saveEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Long idEmployee) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WorkingDay addWorkdayToEmployee(Employee employee, WorkingDay workingDay) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private ResultSet SendSQLServer(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dakDB",
                "root",
                "ekmek"
        );
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

}
