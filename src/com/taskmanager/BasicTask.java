package com.taskmanager;

public class BasicTask extends Task {
    public BasicTask(String name, String description, String creator) {
        super(name, description, creator);
    }

    @Override
    public String getTaskDetails() {
        return String.format("Task Name: %s, Description: %s, Creator: %s", name, description, creator);
    }
}
