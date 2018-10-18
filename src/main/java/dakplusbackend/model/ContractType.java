package dakplusbackend.model;

/**
 * The type of contract an employee can have:
 * - FULLTIME contract, 38 hours per week, no end date
 * - PARTTIME contract, 20 hours per week, no end date
 * - FIXEDTIME contract, 38 hours per week, fixed end date
 */
public enum ContractType {
    FULLTIME, PARTTIME, FIXEDTIME
}

