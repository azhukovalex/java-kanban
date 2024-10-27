package main.models;

public class SingleTask extends Task {

    public SingleTask(String name, String description) {
        super(name, description);
        taskType = TaskType.SINGLETASK;
    }

    public SingleTask(int id, String name, String description, Status status) {
        super(id, name, description, status);
        taskType = main.models.TaskType.SINGLETASK;
    }

    @Override
    public String toString() {
        return "SingleTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}