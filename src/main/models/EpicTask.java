package main.models;

import java.util.ArrayList;
import java.util.List;

public class EpicTask extends Task {
    private List<SubTask> subTasks;

    public EpicTask(int id, String name, String description, Status status) {
        super(id, name, description, status);

        taskType = TaskType.EPICTASK;
    }

    public EpicTask(String name, String description) {
        super(name, description);
        this.subTasks = new ArrayList<>();
        taskType = main.models.TaskType.EPICTASK;
    }

    public List<main.models.SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<main.models.SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    //Overrides


    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", subTasks=" + subTasks +
                '}';
    }
}