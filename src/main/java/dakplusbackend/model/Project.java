package dakplusbackend.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Project {
    private int id;

    private Client client;
    private LocalDate startDateProject;
    private LocalDate endDateProject;
    private BigDecimal price;

}
