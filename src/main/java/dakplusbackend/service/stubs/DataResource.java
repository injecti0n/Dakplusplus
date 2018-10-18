package dakplusbackend.service.stubs;

import dakplusbackend.model.Client;
import dakplusbackend.model.Contract;
import dakplusbackend.model.ContractType;
import dakplusbackend.model.Employee;
import dakplusbackend.model.Project;
import dakplusbackend.model.WorkingDay;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class DataResource {
    public static final DataResource instance = new DataResource();
    private DataResource() { }
    public static final String[] FIRSTNAMES = {
            "Mary",
            "Patricia",
            "Linda",
            "Barbara",
            "Elizabeth",
            "Jennifer",
            "Maria",
            "Susan",
            "Margaret",
            "Dorothy",
            "Lisa",
            "Nancy",
            "Karen",
            "Betty",
            "Helen",
            "Sandra",
            "Donna",
            "Carol",
            "Ruth",
            "Sharon",
            "Michelle",
            "Laura",
            "Sarah",
            "Kimberly",
            "Deborah",
            "Jessica",
            "Shirley",
            "Cynthia",
            "Angela",
            "Melissa",
            "Brenda",
            "Amy",
            "Anna",
            "Rebecca"
    };

    public static final String[] LASTNAMES = {
            "Smith",
            "Johnson",
            "Williams",
            "Jones",
            "Brown",
            "Davis",
            "Miller",
            "Wilson",
            "Moore",
            "Taylor",
            "Anderson",
            "Thomas",
            "Jackson",
            "White",
            "Harris",
            "Martin",
            "Thompson",
            "Garcia",
            "Martinez",
            "Robinson",
            "Clark",
            "Rodriguez",
            "Lewis",
            "Lee",
            "Walker",
            "Hall",
            "Allen",
            "Young",
            "Hernandez"
    };

    private List<Employee> employees;
    private List<Contract> contracts;
    private List<Project> projects;
    private List<WorkingDay> workingDays;
    private List<Client> clients;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<WorkingDay> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<WorkingDay> workingDays) {
        this.workingDays = workingDays;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public static Random random = new Random();
    public static LocalDate newRandomDate() {
        return LocalDate.now()
                .minusYears(random.nextInt(50))
                .minusMonths(random.nextInt(12))
                .minusDays(27);
    }
}
