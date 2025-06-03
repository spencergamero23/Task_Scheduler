package classes;


import java.sql.Date;


public class Task {

    private String name;
    private Date date;
    private String description;
    private String priority;
    private Boolean status;

    public Task(String name, Date date, String description, String priority, Boolean status)
    {
        this.name = name;
        this.date = date;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }
    public Date getDate() { return date;}
    
    public String getName() { return name;}
    
    public String getDescription() { return description;}
    
    public String getPriority() { return priority;}
    
    public Boolean getStatus() { return status;}

}