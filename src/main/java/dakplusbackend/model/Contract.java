package dakplusbackend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Contract class properties:
 * - Employee will point to the Employee that is linked to the contract
 */
public class Contract {
    private Employee employee;
    private LocalDate startDate;
    private LocalDate endDate;
    private ContractType contractType;
	private BigDecimal salary = new BigDecimal(0);

    public Contract() {}

    public Contract(Employee currentEmployee) {

    }

    public Employee getEmployee() {
    	
        return employee;
    }

    public void setEmployee(Employee employee) {
 
    	
    	
        this.employee = employee;
        
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }
}
