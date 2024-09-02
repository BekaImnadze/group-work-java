package com.taskmanager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    public void createTask(Scanner scanner, String creator) {
        System.out.print("Enter task type (Basic, LimitedTime, Repeatable): ");
        String type = scanner.nextLine();
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();

        if (tasks.containsKey(name)) {
            System.out.println("Task with this name already exists.");
            return;
        }

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task task = null;
        switch (type.toLowerCase()) {
            case "basic":
                task = new BasicTask(name, description, creator);
                break;
            case "limitedtime":
                System.out.print("Enter deadline (yyyy-MM-dd HH:mm): ");
                String deadlineStr = scanner.nextLine();
                LocalDateTime deadline = LocalDateTime.parse(deadlineStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                task = new LimitedTimeTask(name, description, creator, deadline);
                break;
            case "repeatable":
                System.out.print("Enter repeat count: ");
                int repeatCount = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter repeat until (yyyy-MM-dd HH:mm): ");
                String repeatUntilStr = scanner.nextLine();
                LocalDateTime repeatUntil = LocalDateTime.parse(repeatUntilStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                task = new RepeatableTask(name, description, creator, repeatCount, repeatUntil);
                break;
            default:
                System.out.println("Unknown task type.");
                return;
        }

        tasks.put(name, task);
        System.out.println("Task created successfully.");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            tasks.keySet().forEach(System.out::println);
        }
    }

    public void updateTask(Scanner scanner) {
        System.out.print("Enter task name to update: ");
        String name = scanner.nextLine();

        Task task = tasks.get(name);
        if (task == null) {
            System.out.println("Task does not exist.");
            return;
        }

        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        task.setDescription(description);

        if (task instanceof LimitedTimeTask) {
            System.out.print("Enter new deadline (yyyy-MM-dd HH:mm): ");
            String deadlineStr = scanner.nextLine();
            LocalDateTime deadline = LocalDateTime.parse(deadlineStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            ((LimitedTimeTask) task).setDeadline(deadline);
        } else if (task instanceof RepeatableTask) {
            System.out.print("Enter new repeat count: ");
            int repeatCount = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new repeat until (yyyy-MM-dd HH:mm): ");
            String repeatUntilStr = scanner.nextLine();
            LocalDateTime repeatUntil = LocalDateTime.parse(repeatUntilStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            ((RepeatableTask) task).setRepeatCount(repeatCount);
            ((RepeatableTask) task).setRepeatUntil(repeatUntil);
        }

        System.out.println("Task updated successfully.");
    }

    public void deleteTask(Scanner scanner) {
        System.out.print("Enter task name to delete: ");
        String name = scanner.nextLine();

        if (tasks.remove(name) == null) {
            System.out.println("Task does not exist.");
        } else {
            System.out.println("Task deleted successfully.");
        }
    }

    public void viewTask(Scanner scanner) {
        System.out.print("Enter task name to retrieve: ");
        String name = scanner.nextLine();

        Task task = tasks.get(name);
        if (task == null) {
            System.out.println("Task does not exist.");
        } else {
            System.out.println(task.getTaskDetails());
        }
    }
}
