package models;
import java.util.HashMap;
import java.util.Collection;

public class Epic extends Task{
    private final HashMap<Integer, SubTask> subtasks = new HashMap<>();

    //Constructors
    public Epic(int id, String title, String description, TaskStates taskStates) {
        super(id, title, description, taskStates);
    }

    public Epic(String title, String description) {
        super(title, description);
    }

    //Getters
    public Collection<SubTask> getSubtasks() {
        return subtasks.values();
    }

    //Operations
    public void addSubtask(SubTask subtask) {
        subtasks.put(subtask.getId(), subtask);
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

    public void updateStatus() {
        boolean doneStateTotal = true;
        boolean newStateTotal = true;
        
        if (subtasks.isEmpty()) {
            setState(TaskStates.NEW);
            return;
        }
        for (SubTask subtask : subtasks.values()) {
            if (subtask.getStatus() != TaskStates.DONE) {
                doneStateTotal = false;
            }
            if (subtask.getStatus() != TaskStates.NEW) {
                newStateTotal = false;
            }
        }

        if (doneStateTotal) {
            setState(TaskStates.DONE);
        } else if (newStateTotal) {
            setState(TaskStates.NEW);            
        } else {
            setState(TaskStates.IN_PROGRESS);
        }
    }

    public void deleteSubtask(int id) {
        if (subtasks.containsKey(id)) {
            subtasks.remove(id);
            updateStatus();
        }
    }

    public void deleteAllSubtasks() {
        subtasks.clear();
        updateStatus();
    }
}