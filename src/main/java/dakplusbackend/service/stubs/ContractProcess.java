package dakplusbackend.service.stubs;

import dakplusbackend.model.Contract;
import dakplusbackend.model.Employee;
import dakplusbackend.service.ContractService;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ContractProcess implements ContractService {
	Employee employee;
	DataProcess dataPro;
	String sqlInsert = "";
	String sqlInsertSecond = "";
	Long ContractID;
	private List<Contract> contracts = new ArrayList<>();
	private static AtomicLong numberGenerator = new AtomicLong(910000000000L);

	public ContractProcess() {
	}

	private List<Contract> RetrieveData(ResultSet rs) throws SQLException {
		List<Contract> resultList = new ArrayList<>();

		while (rs.next()) {
			Contract cont = new Contract();
			ContractID = rs.getLong("Id");
			resultList.add(cont);
		}

		return resultList;
	}

	public static long getNext() {
		return numberGenerator.getAndIncrement();
	}

	@Override
	public Contract saveContract(Contract contract) {
		String sql;

		try {
			sql = String.format("SELECT max(Id)+1 FROM contract");
			ResultSet rs = dataPro.SendSQLServer(sql);
			Long user_id;
			while (rs.next()) {
				user_id = rs.getLong(1);
				sqlInsert = String.format(
						"INSERT INTO contract (Id,startDate,endDate,contractType,salary) VALUES ('%d','%s','%s','%s','%s')",
						user_id, contract.getStartDate(), contract.getEndDate(), contract.getContractType(),
						contract.getSalary());
				sqlInsertSecond = String.format("UPDATE employees SET idcontract= LAST_INSERT_ID()");
				boolean i = dataPro.SendInsertQuery(sqlInsert);
				boolean x = dataPro.SendInsertQuery(sqlInsertSecond);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Received contract: " + contract);

		return contract;
	}

	@Override
	public BigDecimal calculateSalary(Contract contract) {
		return null;
	}
}
