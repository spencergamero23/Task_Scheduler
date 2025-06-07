package classes;

import java.time.LocalDate;


public class Task {

    private String name;
    private LocalDate date;
    private String description;

    public Task(String name, LocalDate date, String description)
    {
        this.name = name;
        this.date = date;
        this.description = description;
    }
    public LocalDate getDate() { return date;}
    
    public String getName() { return name;}
    
    public String getDescription() { return description;}

}