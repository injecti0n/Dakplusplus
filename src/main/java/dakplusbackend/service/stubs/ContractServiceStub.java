package dakplusbackend.service.stubs;

import dakplusbackend.model.Contract;
import dakplusbackend.service.ContractService;

import java.math.BigDecimal;

public class ContractServiceStub implements ContractService {

    public ContractServiceStub() { }

    @Override
    public Contract saveContract(Contract contract) {
        return null;
    }

    @Override
    public BigDecimal calculateSalary(Contract contract) {
        return null;
    }
}
