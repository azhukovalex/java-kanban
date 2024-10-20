package models;

import java.util.HashMap;
import java.util.Collection;

public class TaskManager {
    private int id = 0;
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();

    private final HashMap<Integer, SubTask> subtasks = new HashMap<>();

    //Creating
    public Epic createEpic(Epic epic) {
        epic.setId(++id);
        epics.put(epic.getId(), epic);
        return epic;
    }

    public Task createTask(Task task) {
        task.setId(++id);
        tasks.put(task.getId(), task);
        return task;
    }

    public SubTask createSubTask(SubTask subtask) {
        subtask.setId(++id);
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            epic.addSubtask(subtask);
        }
        return subtask;
    }

    //Getters
    public Epic getEpic(int id) {
        return epics.get(id);
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public SubTask getSubTask(int id) {
        return subtasks.get(id);
    }

    public Collection<Task> getAllTasks() {
        return tasks.values();
    }

    public Collection<SubTask> getAllSubTasks() {
        return subtasks.values();
    }

    public Collection<Epic> getAllEpics() {
        return epics.values();
    }

    //Deleting
    public void deleteEpic(int id) {
        if (!epics.containsKey(id)) {
            return;
        }
        Epic epic = epics.get(id);
        if (epic != null) {
            epic.deleteAllSubtasks();
        }
        epics.remove(id);
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public void deleteSubTask(int id) {
        SubTask subtask = subtasks.remove(id);
        if (subtask != null) {
            Epic epic = epics.get(subtask.getEpicId());
            if (epic != null) {
                epic.deleteSubtask(subtask.getId());
            }
        }
    }

    //Updatimg
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateSubTask(SubTask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            epic.addSubtask(subtask);
            epic.updateStatus();
        }
    }
}