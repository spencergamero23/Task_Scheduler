# Overview

As I am a student in college I did want to experiment with learning a new language like Java. Something that I do really need is a task manager that I can use for my classes. So what better than to create a new project while learning a new language. I hope eventually I can make it an actual program that I can interact with.


I created a task manager that has a menu showing that you can do 5 things: Add task, remove task, view tasks, load file, and exit.

#### 1. Add task:
What add task does is it creates a new Task object that has 3 parameters: Name, Date, and Description. The user fills out these 3 parameters and then it's added to another object TaskManager which is a list that holds the Task objects. Because of this it is able to organize the Tasks by date.
#### 2. Remove task:
What remove task does is display a list of your tasks while grouping them by the date they were assigned. You just input the name of the task and it'll remove it from your TaskManager.
#### 3. View tasks:
View tasks just displays all your tasks grouping them by date and showing their discriptions.
#### 4. Load File:
Load File takes the name of a file saved in your folder and reads it line by line. It then seperates the lines and puts it into a list which then respectively are assigned to variables for the Task objects parameters.
#### 5. Exit:
Exit asks if you want to save your file. If you say yes it'll ask for a name and it'll either create a new file or overwrite a file you already have. Either way it'll be writing the values into the file.

My reasoning for writing this program is to help better my life.


[Software Demo Video](https://youtu.be/4ZS9xjb1KvI)

# Development Environment

The tools I used for this would have to be Java. Java extensions really helped make this a quick and process! I used a couple of libraries such as: File, Filewriter, Scanner, and a bunch of time and date libraries.

# Useful Websites

- [W3Schools](https://www.w3schools.com/java/default.asp)
- [GeeksForGeeks](https://www.geeksforgeeks.org/writing-list-contents-to-text-file-after-deleting-string-in-java/)

# Future Work



- Something I do want to imrpove is making the code a lot more readable as well as not having so much in the main file. Maybe I'll have to add some more methods to classes or make a new class.
- Definitely want to try making it an actualy program with buttons. Would be super fun experience and an even better way of displaying the project.
- Definitely gotta be able to put the .txt files in a folder.