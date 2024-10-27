package main.models;


public class SubTask extends Task {
    private final int epicId;

    //Constructors
    public SubTask(int id, String title, String description, main.models.Status status, int epicId) {
        super(id, title, description, status);
        this.epicId = epicId;
    }

    public SubTask(String name, String description, int epicId) {
        super(name, description);
        this.epicId = epicId;
        taskType = TaskType.SUBTASK;
    }

    //Getters
    public int getEpicId() {
        return epicId;
    }

    //Overrides

    @Override
    public String toString() {
        return "SubTask{" +
                "epicId=" + epicId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}
