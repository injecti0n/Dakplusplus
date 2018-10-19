package dakplusbackend.service.stubs;

import java.math.BigDecimal;
import java.time.LocalDate;

import dakplusbackend.model.Contract;
import dakplusbackend.model.Employee;
import dakplusbackend.service.ContractService;

public class ContractProcess implements ContractService{
	private Employee currentEmployee;
	@Override
	public Contract saveContract(Contract contract) {
		DateConvert convert = new DateConvert();
		Long currentID = currentEmployee.getId();
		LocalDate dateToConvert = currentEmployee.getBirthDay();
		System.out.println(DateConvert.convertToDateViaInstant(employee.getBirthDay()));
		sql = String.format(
				"INSERT INTO contract (idemployees,firstName,lastName,birthDay) VALUES ('%d','%s','%s','%s')",
				currentEmployee.getId(), currentEmployee.getFirstName(), currentEmployee.getLastName(), currentEmployee.getBirthDay());
		
		boolean rs = SendInsertQuery(sql);
		currentEmployee.
		
		
		return contract;
	}

	@Override
	public BigDecimal calculateSalary(Contract contract) {
		// TODO Auto-generated method stub
		return null;
	}

}
