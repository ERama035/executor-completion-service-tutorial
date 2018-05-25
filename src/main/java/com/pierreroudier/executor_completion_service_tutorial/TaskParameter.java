package com.pierreroudier.executor_completion_service_tutorial;

public class TaskParameter {
    private final String label;
    private final long number;

    public TaskParameter(String label, long number) {
        this.label = label;
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public long getNumber() {
        return number;
    }
}
