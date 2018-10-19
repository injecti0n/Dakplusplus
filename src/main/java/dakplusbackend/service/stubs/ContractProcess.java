package dakplusbackend.service.stubs;

import dakplusbackend.model.Contract;
import dakplusbackend.model.Employee;
import dakplusbackend.service.ContractService;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ContractProcess implements ContractService {
	Employee employee;
	DataProcess dataPro;
    public ContractProcess() { }

   
    @Override
    public Contract saveContract(Contract contract) {
    	
    	String sql = "";
    	System.out.println("Received contract: " + contract);
    	DateConvert convert = new DateConvert();

		//LocalDate dateToConvert = contract.getBirthDay();
		try {
			System.out.println(DateConvert.convertToDateViaInstant(employee.getBirthDay()));
			sql = String.format("");
			System.out.println(sql);
			boolean rs = dataPro.SendInsertQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("Received emp: " + employee);
        return contract;
    }

    @Override
    public BigDecimal calculateSalary(Contract contract) {
        return null;
    }
}
