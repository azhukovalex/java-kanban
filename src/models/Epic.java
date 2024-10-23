package models;
import java.util.ArrayList;

public class Epic extends Task{
    private final ArrayList<Integer> subtasks = new ArrayList<>();

    //Constructors
    public Epic(int id, String title, String description, TaskStates taskStates) {
        super(id, title, description, taskStates);
    }

    public Epic(String title, String description) {
        super(title, description);
    }

    //Getters
    public ArrayList<Integer> getSubtasks() {
        return subtasks;
    }

    //Operations
    public void addSubtask(Integer id) {
        subtasks.add(id);
    }

    //Overrides
    @Override
    public String toString() {
        return "Epic {" +
                "id = " + getId() +
                ", title = '" + getTitle() + '\'' +
                ", description = '" + getDescription() + '\'' +
                ", status = " + getStatus() +
                ", subtasks count = " + getSubtasks().size() +
                '}';
    }

    public void updateStatus(TaskStates status) {
        setState(status);
    }

    public void deleteSubtask(int id) {
        if (subtasks.contains(id)) {
            int index = subtasks.indexOf(id);
            subtasks.remove(index);
        }
    }

    public void deleteAllSubtasks() {
        subtasks.clear();
    }
}