import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import  java.util.Scanner;
import classes.Task;
import classes.TaskManager;
import java.util.ArrayList;
import java.util.ListIterator;


public class project_main {
// What does this task manager do?
// Prompt: Task Scheduler with Calendar: Create a task scheduler with an integrated calendar that allows users to manage events and tasks.
// Our project is the task scheduler!
// It includes: an integrated calendar. What does the calendar do? It allows user to manage events and tasks!
// Two classes we would need is:
//task: name, date, description, and status
//task manager: adds tasks, remove tasks, retrieves tasks by date

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        TaskManager taskManager = new TaskManager();

        System.out.println("Hello and welcome to a task manager!");
        while(input != "4" || input != "Exit"){
            System.out.println("Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");

            input = sc.nextLine();

            if (input.equals("1") || input.equalsIgnoreCase("Add Task"))
            {
                // Getting name
                System.out.println("What's the name of this task?");
                String name = sc.nextLine();
                
                // Getting date
                System.out.println("What date should this be done? Format:(August 12 2025)");
                String dateString = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
                LocalDate date = LocalDate.parse(dateString, formatter);

                // Getting description
                System.out.println("Write a description for the task.");
                String description  = sc.nextLine();

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
                
                String removeString = sc.nextLine();

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
            else if (input.equals("3") || input.equalsIgnoreCase( "View tasks")){
                System.out.println("Here's your list of tasks:");
                System.out.println();
                
                LocalDate previousDate = null;

                for (Task task : taskManager.getTasks())
                {
                    LocalDate currentDate = task.getDate();
                    if(previousDate == null || !currentDate.equals(previousDate))
                    {
                        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH));
                        System.out.println(formattedDate + ":");
                        previousDate = currentDate;
                        
                    }
        
                    System.out.println("  - " + task.getName());
                    System.out.println("    " + task.getDescription());
                    System.out.println();
                }
            }
            else if (input.equals("4") || input.equalsIgnoreCase( "Exit")){
                System.out.println("Thanks for using the app! See you soon.");
                // Lets try fixing this
            } 

            else{
                System.out.println("ERROR: input one of the choices above.");
                return;
            }
        }
        
        


        
    }

}

//I want to list the tasks by date. So everytime theres a different date it'll print out the day. How do I go about doing this?
// we are iterating through a list [fart,pee,poop,chungus]
//If we do a for loop it'll go through each one:
// August 12th 2025:
//  Fart
// September 12th 2025:
//  Pee
// October 12th 2025:
//  poop
// 
// However what happens when we have two dates that are side by side?
// [Fart(August),peee(August),Poop(August)]
// I think we write an if statement where if the previous .getDate() value is equal to the current we just don't print out the date.
// However if that's not the case we will print out the new value. No need to worry about disorginization either because they are ordered by date already!