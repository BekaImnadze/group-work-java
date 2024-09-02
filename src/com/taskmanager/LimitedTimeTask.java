package com.taskmanager;

import java.time.LocalDateTime;

public class LimitedTimeTask extends Task {
    private LocalDateTime deadline;

    public LimitedTimeTask(String name, String description, String creator, LocalDateTime deadline) {
        super(name, description, creator);
        this.deadline = deadline;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String getTaskDetails() {
        return String.format("Task Name: %s, Description: %s, Creator: %s, Deadline: %s",
                name, description, creator, deadline.toString());
    }
}
