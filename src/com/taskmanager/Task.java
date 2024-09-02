package com.taskmanager;

public abstract class Task {
    protected String name;
    protected String description;
    protected String creator;

    public Task(String name, String description, String creator) {
        this.name = name;
        this.description = description;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public abstract String getTaskDetails();
}
