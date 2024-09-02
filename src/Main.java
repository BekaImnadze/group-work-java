import com.taskmanager.TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        while (true) {
            System.out.println("\nChoose process: ");
            System.out.println("create - Save a new task");
            System.out.println("list - Show all tasks");
            System.out.println("update - Update a specific task");
            System.out.println("delete - Delete a specific task");
            System.out.println("view - View a specific task");
            System.out.println("Type 'exit' to quit the application");
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "create":
                    taskManager.createTask(scanner, username);
                    break;
                case "list":
                    taskManager.listTasks();
                    break;
                case "update":
                    taskManager.updateTask(scanner);
                    break;
                case "delete":
                    taskManager.deleteTask(scanner);
                    break;
                case "view":
                    taskManager.viewTask(scanner);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}