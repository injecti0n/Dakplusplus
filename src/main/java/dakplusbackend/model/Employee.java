package dakplusbackend.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

/**
 * Employee class properties: - id: we will use the national number
 * (Rijksregisternummer) as the Primary Key - contract: 1-1 relation. An
 * employee has 1 contract. Contract belongs to 1 employee
 *
 */
public class Employee {
	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthDay;

	private Contract contract;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate date) {
		this.birthDay = date;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", birthDay=" + birthDay + '}';
	}
}
