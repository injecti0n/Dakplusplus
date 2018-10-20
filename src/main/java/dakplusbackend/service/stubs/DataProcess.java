package dakplusbackend.service.stubs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;


import dakplusbackend.model.Contract;
import dakplusbackend.model.Employee;
import dakplusbackend.model.WorkingDay;
import dakplusbackend.service.EmployeeService;

public class DataProcess implements EmployeeService {
	private List<Employee> employees = new ArrayList<>();
	private List<Contract> contracts = new ArrayList<>();

	public DataProcess() {
		// if (employees.size() == 0) initData();
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
		String sql = String.format(
				"SELECT * FROM employees e1 INNER JOIN contract c1 ON e1.idcontract = c1.idcontract");
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
		Employee emp = new Employee();
		id = emp.getId();
		return emp;
	}

	@Override
	public Employee refreshEmployee(Employee employee) throws SQLException, NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee saveEmployee(Employee employee) throws SQLException {
		System.out.println("Received emp: " + employee);
		String sql = "";
		Random random = new Random();
		employee.setId(1990000000000L + random.nextInt(1000000000));

		if (employee.getId() == null) {

			sql = String.format(
					"UPDATE employees SET idemployees = '%d' , firstName = '%s', lastName = '%s' ,birthDay = '%s' WHERE idemployees = '%d'",
					employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getBirthDay(),
					employee.getId());
		} else {
			DateConvert convert = new DateConvert();

			LocalDate dateToConvert = employee.getBirthDay();
			System.out.println(DateConvert.convertToDateViaInstant(employee.getBirthDay()));
			sql = String.format(
					"INSERT INTO employees (idemployees,firstName,lastName,birthDay) VALUES ('%d','%s','%s','%s')",
					employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getBirthDay());
			
		}
		
		System.out.println(sql);
		boolean rs = SendInsertQuery(sql);
		employees.add(employee);

		System.out.println("Received emp: " + employee);
		return employee;
}


	@Override
	public void deleteEmployee(Employee employee) throws SQLException {
		Long DelID = employee.getId();
		SendDeleteQuery(DelID);

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

	public static ResultSet SendSQLServer(String sql) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dakDB", "root", "");
		Statement statement = connection.createStatement();
		return statement.executeQuery(sql);
	}

	public static boolean SendInsertQuery(String sql) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dakDB", "root", "");
		Statement statement = connection.createStatement();
		return statement.execute(sql);
	}

	private int SendDeleteQuery(Long id) throws SQLException {
		String sql = "DELETE FROM employees WHERE idemployees = ?";
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dakdb", "root", "");
		Statement statement = connection.createStatement();
		
		PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setLong(1, id);
			
		
		return psmt.executeUpdate();
	}

	public LocalDate setAsText(String text) throws IllegalArgumentException {
		return LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
	}

}
