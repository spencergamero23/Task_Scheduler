import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import  java.util.Scanner;
import classes.Task;
import classes.TaskManager;
import java.util.ArrayList;


public class project_main {
// What does this task manager do?
// Prompt: Task Scheduler with Calendar: Create a task scheduler with an integrated calendar that allows users to manage events and tasks.
// Our project is the task scheduler!
// It includes: an integrated calendar. What does the calendar do? It allows user to manage events and tasks!
// Two classes we would need is:
//task: name, date, description, and status
//task manager: adds tasks, remove tasks, retrieves tasks by date

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String input = "";
        TaskManager taskManager = new TaskManager();

        System.out.println("Hello and welcome to a task manager!");
        while(input != "4" || input != "Exit"){
            System.out.println("Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");

            input = myObj.nextLine();

            if (input == "1" || input == "Add Task"){
                // Getting name
                System.out.println("What's the name of this task?");
                String name = myObj.nextLine();
                
                // Getting date
                System.out.println("What date should this be done? Format:(MMMM dd yyyy)");
                String dateString = myObj.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
                LocalDate date = LocalDate.parse(dateString, formatter);

                // Getting description
                System.out.println("Write a description for the task.");
                String description  = myObj.nextLine();

                // Current Status
                String status = "Incomplete";

                Task task = new Task(name,date,description,status);

                taskManager.addTask(task);
                taskManager.sortTasksByDate();


            }
            else if (input.equals("2") || input.equalsIgnoreCase( "Remove Task")){
                System.out.println("Which task would you like to remove?");
                for (Task task : taskManager.getTasks())
                {
                    System.out.println(task.getName() + "-" + task.getDate());
                }
                
                String removeString = myObj.nextLine();

                Task taskToRemove = null;


                // Loop through the task names and compare to the one we want to remove.
                for (Task task: taskManager.getTasks())
                {
                    if(task.getName().equalsIgnoreCase(removeString))
                    {
                        taskToRemove = task;
                        break;
                    }
                }
                //update user if task is removed
                System.out.println(taskToRemove != null ? "Removed " + removeString : "Failed to remove task");                    


            }
            else if (input == "3" || input == "View Tasks"){
                System.out.println("Which task would you like to remove?");
                for (Task task : taskManager.getTasks())
                {
                    System.out.println(task.getName() + "-" + task.getDate());
                }
            }

            else{
                System.out.println("ERROR: input one of the choices above.");
                return;
            }
        }
        
        


        
    }

}
