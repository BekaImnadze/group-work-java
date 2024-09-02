package com.taskmanager;

import java.time.LocalDateTime;

public class RepeatableTask extends Task {
    private int repeatCount;
    private LocalDateTime repeatUntil;

    public RepeatableTask(String name, String description, String creator, int repeatCount, LocalDateTime repeatUntil) {
        super(name, description, creator);
        this.repeatCount = repeatCount;
        this.repeatUntil = repeatUntil;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public LocalDateTime getRepeatUntil() {
        return repeatUntil;
    }

    public void setRepeatUntil(LocalDateTime repeatUntil) {
        this.repeatUntil = repeatUntil;
    }

    @Override
    public String getTaskDetails() {
        return String.format("Task Name: %s, Description: %s, Creator: %s, Repeat Count: %d, Repeat Until: %s",
                name, description, creator, repeatCount, repeatUntil.toString());
    }
}
