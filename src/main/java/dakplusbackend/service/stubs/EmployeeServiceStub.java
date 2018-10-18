package dakplusbackend.service.stubs;

import dakplusbackend.model.Contract;
import dakplusbackend.model.ContractType;
import dakplusbackend.model.Employee;
import dakplusbackend.model.WorkingDay;
import dakplusbackend.service.EmployeeService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EmployeeServiceStub implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private List<Contract> contracts = new ArrayList<>();

    private Random random = ThreadLocalRandom.current();

    public EmployeeServiceStub() {
        if (employees.size() == 0) initData();
    }

    protected List<Contract> getContracts() {
        return contracts;
    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            Employee e = new Employee();
            e.setId(1990000000000L + random.nextInt(1000000000));
            e.setFirstName(DataResource.FIRSTNAMES[random.nextInt(DataResource.FIRSTNAMES.length)]);
            e.setLastName(DataResource.LASTNAMES[random.nextInt(DataResource.LASTNAMES.length)]);
            e.setBirthDay(DataResource.newRandomDate());
            employees.add(e);
        }

        AtomicInteger employeeCounter = new AtomicInteger();
        employees.stream().forEach(e -> {
            Contract c = new Contract();
            c.setEmployee(e);
            c.setSalary(new BigDecimal(2000 + random.nextInt(500)));
            c.setStartDate(DataResource.newRandomDate());
            if (employeeCounter.getAndIncrement() / 4 != 0) c.setEndDate(DataResource.newRandomDate());
            c.setContractType(ContractType.values()[random.nextInt(ContractType.values().length)]);
            e.setContract(c);
            contracts.add(c);
        });
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public List<Employee> getAllEmployeeByNameContaining(final String name) {
        return employees
                .stream()
                .filter(employee -> employee.getFirstName().contains(name) || employee.getLastName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployeeWithActiveContract() {
        return employees
                .stream()
                .filter(employee -> employee.getContract() != null && employee.getContract().getEndDate() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployeeWithActiveContractAndNameContaining(final String name) throws SQLException {
        return employees
                .stream()
                .filter(employee -> employee.getContract() != null && employee.getContract().getEndDate() == null)
                .filter(employee -> (employee.getFirstName() != null && employee.getFirstName().contains(name)) ||
                        (employee.getLastName() != null && employee.getLastName().contains(name)))
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployee(Long id) throws NoSuchElementException {
        return employees
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public Employee refreshEmployee(Employee employee) throws SQLException, NoSuchElementException {
        Optional<Employee> optionalEmployee =
                employees
                    .stream()
                    .filter(emp -> emp.getId().equals(employee.getId()))
                    .findFirst();

        if (!optionalEmployee.isPresent()) throw new NoSuchElementException("Element not found");
        return optionalEmployee.get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getId() == null) {
            long newID;
            boolean foundId;
            do {
                newID = 1990000000000L + random.nextInt(1000000000);
                try {
                    getEmployee(newID);
                    foundId = true;
                } catch (NoSuchElementException e) {
                    foundId = false;
                }
            } while (foundId);
            employee.setId(newID);
        }

        employees.add(employee);
        System.out.println(String.format("Received Employee in service. %s", employee));
        return employee;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        if (employee.getId() == null || !employees.contains(employee))
            throw new NoSuchElementException("Employee not found in database");

        employees.remove(employee);
    }

    @Override
    public void deleteEmployee(Long idEmployee) {
        employees.remove(
                employees.stream().filter(e -> e.getId().equals(idEmployee))
        );
    }

    /**
     * TODO
     *
     * @param employee
     * @param workingDay
     * @return
     */
    @Override
    public WorkingDay addWorkdayToEmployee(Employee employee, WorkingDay workingDay) {
        return null;
    }
}
