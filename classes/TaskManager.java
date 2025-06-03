package classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }
    
    public void removeTask(Task task){
        tasks.remove(task);
    }

    public void sortTasksByDate(){
        tasks.sort(Comparator.comparing(Task::getDate));
    }
    public List<Task> getTasks(){
        return tasks;
    }
}
