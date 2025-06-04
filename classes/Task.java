package classes;

import java.time.LocalDate;


public class Task {

    private String name;
    private LocalDate date;
    private String description;
    private String status;

    public Task(String name, LocalDate date, String description, String status)
    {
        this.name = name;
        this.date = date;
        this.description = description;
        this.status = status;
    }
    public LocalDate getDate() { return date;}
    
    public String getName() { return name;}
    
    public String getDescription() { return description;}
    
    public String getStatus() { return status;}

}