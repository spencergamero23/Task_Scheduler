import  java.util.Scanner;

public class project_main {
// What does this task manager do?
// Prompt: Task Scheduler with Calendar: Create a task scheduler with an integrated calendar that allows users to manage events and tasks.
// Our project is the task scheduler!
// It includes: an integrated calendar. What does the calendar do? It allows user to manage events and tasks!
// Two classes we would need is:
//task: name, date, description, priority, and status
//task manager: adds tasks, remove tasks, retrieves tasks by date

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String input;

        Systesm.out.println("Hello and welcome to a task manager!")
        While (input == "4" || input == "Exit"){
            System.out.println("Menu:")
            System.out.println("1. Add Task")
            System.out.println("2. Remove Task")
            System.out.println("3. View Tasks")
            System.out.println("4. Exit")

            input = myObj.nextLine();

            if (input == "1" || input == "Add Task"){

            }
            else if (input == "2" || input == "Remove Task"){

            }
            else if (input == "3" || input == "View Tasks"){

            }

            else{
                System.out.println("ERROR: input one of the choices above.")
            }
        }
        

        
    }
}
