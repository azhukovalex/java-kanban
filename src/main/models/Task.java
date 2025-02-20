package main.models;


import java.util.Objects;

public class Task {
    protected int id;
    protected String name;
    protected String description;
    protected Status status;
    protected TaskType taskType;

    //Constructors
    public Task(int id, String name, String description, Status state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = state;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = Status.NEW;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public main.models.Status getStatus() {
        return status;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(main.models.Status status) {
        this.status = status;
    }

    //Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(description, task.description) && status == task.status && taskType == task.taskType;
    }

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    @Override
    public String toString() {
        return "Task {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + status +
                '}';
    }
}

