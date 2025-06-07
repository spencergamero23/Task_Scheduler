import java.io.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import  java.util.Scanner;
import classes.Task;
import classes.TaskManager;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


public class project_main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        TaskManager taskManager = new TaskManager();

        System.out.println("Hello and welcome to a task manager!");
        while(!input.equals("5") && !input.equalsIgnoreCase("Exit")){
            System.out.println("Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Load File");
            System.out.println("5. Exit");

            input = sc.nextLine();

            if (input.equals("1") || input.equalsIgnoreCase("Add Task"))
            {
                // Getting name
                System.out.println("What's the name of this task?");
                String name = sc.nextLine();
                
                // Getting date
                LocalDate date = null;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);

                while(true){
                    System.out.println("What date should this be done? Format:(August 12 2025)");
                    String dateString = sc.nextLine();

                    try{
                        date = LocalDate.parse(dateString, formatter);
                        break;
                    }
                    catch(DateTimeParseException e){
                        
                        System.out.println("Invalid date format please try again.");
                    }
                }
                
                // Getting description
                System.out.println("Write a description for the task.");
                String description  = sc.nextLine();


                Task task = new Task(name,date,description);

                taskManager.addTask(task);
                taskManager.sortTasksByDate();


            }
            else if (input.equals("2") || input.equalsIgnoreCase( "Remove Task")){
                System.out.println("Which task would you like to remove?");
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
                    System.out.println();
                }
                
                String removeString = sc.nextLine();

                Task taskToRemove = null;


                // Loop through the task names and compare to the one we want to remove.
                for (Task task: taskManager.getTasks())
                {
                    if(task.getName().equalsIgnoreCase(removeString))
                    {
                        taskToRemove = task;
                        taskManager.removeTask(taskToRemove);
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
            else if (input.equals("4") || input.equalsIgnoreCase( "Load")){

                 System.out.println("What's the name of the file? (No file extension: .txt)");

                String fileName = sc.nextLine().trim();

                File file = new File(fileName + ".txt");

                if (!file.exists()){
                    System.out.println("File not found: "+ fileName);
                    return;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                try(Scanner reader = new Scanner(file)){
                    int loadedCount = 0;

                    while(reader.hasNextLine()){
                        String line = reader.nextLine();
                        String[] parts = line.split("::");

                        if (parts.length >= 3) {
                            try{
                                String name = parts[0];
                                LocalDate date = LocalDate.parse(parts[1], formatter);
                                String description = parts[2];

                                taskManager.addTask(new Task(name, date, description));
                                loadedCount++;
                            } catch(Exception e){
                                System.out.println("Skipped incomplete task: " + line);
                            }
                            
                        } else{
                            System.out.println("Skipped incomplete task: " + line);
                        }
                    }

                    System.out.println("Loaded " + loadedCount + "task(s) from file");
                } catch(IOException e){
                    System.out.println("Error reading file: " + e.getMessage());
                }

            }

            else if (input.equals("5") || input.equalsIgnoreCase( "Exit")){

                System.out.println("Would you like to save your information? (Y/N)");
                String choiceString = sc.nextLine().trim().toLowerCase();

                if (!choiceString.equals("y")) {
                    System.out.println("Thanks for using the app! See you soon.");
                    return;
                }

                System.out.println("What's the name of the file? (No file extension: .txt)");

                String fileName = sc.nextLine().trim();

                File file = new File(fileName + ".txt");

                try{
                    if(file.createNewFile()){
                        System.out.println("File created: " + file.getName());

                    }else{
                        System.out.println("File already exists. Overwriting...");
                    }

                    FileWriter writer = new FileWriter(file);
                    for (Task task : taskManager.getTasks()) {
                        writer.write(task.getName() + "::"+task.getDate() + "::"+task.getDescription() + "\n");
                    }

                    writer.close();
                    System.out.println("Succesfully wrote to the file.");

                } catch(IOException e){
                    System.out.println("An error ocurred.");
                    e.printStackTrace();
                }
                
               System.out.println("Thanks for using the app! See you soon.");
            } 

            else{
                System.out.println("ERROR: input one of the choices above.");
                return;
            }
        }
        
    }

}
