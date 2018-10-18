package dakplusbackend.service;

import dakplusbackend.model.Contract;

import java.math.BigDecimal;

public interface ContractService {
    /**
     * Saves the {@link Contract} and the attached {@link dakplusbackend.model.Employee Employee} instance
     * to the database. <p>
     * @param contract The object to be saved to the database (layer)
     * @return The saved object after being saved to the database
     */
    Contract saveContract(Contract contract);

    /**
     * Calculates an employees salary for a given month based on the amount of days worked
     * and the ContractType
     *
     * @return BigDecimal with that months salary following the criteria below:<p>
     *  - FULLTIME : Will receive the full monthly salary<p>
     *  - PARTTIME : Will receive half of the monthly salary<p>
     *  - FIXEDTIME : Will receive a monthly salary based on the hours/days worked that month<p>
     *  PS Remember this is fictional, you can be a bit creative with the logic<p>
     */
    BigDecimal calculateSalary(Contract contract);
}
