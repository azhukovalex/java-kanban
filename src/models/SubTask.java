package models;

public class SubTask extends Task {
    private final int epicId;

    //Constructors
    public SubTask(int id, String title, String description, TaskStates taskStates, int epicId) {
        super(id, title, description, taskStates);
        this.epicId = epicId;
    }

    public SubTask(String title, String description, int epicId) {
        super(title, description);
        this.epicId = epicId;
    }

    //Getters
    public int getEpicId() {
        return epicId;
    }

    //Overrides
    @Override
    public String toString() {
        return "SubTask {" +
                "id = " + getId() +
                ", title = '" + getTitle() + '\'' +
                ", description = '" + getDescription() + '\'' +
                ", status = " + getStatus() +
                ", epicId = " + getEpicId() +
                '}';
    }
}