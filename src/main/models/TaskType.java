package main.models;

public enum TaskType {
    SINGLETASK("SINGLETASK"),
    SUBTASK("SUBTASK"),
    EPICTASK("EPICTASK");

    private final String value;

    TaskType(String value) {
        this.value = value;
    }
    public String toString() {
        return value;
    }
}