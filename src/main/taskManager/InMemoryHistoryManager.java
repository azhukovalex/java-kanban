package main.taskManager;

import main.models.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private List<Task> history = new ArrayList<>();

    @Override
    public void add(Task task) {
        history.add(task);
    }

    @Override
    public void remove(Task task) {
        history.remove(task);
    }


    @Override
    public List<Task> getHistory() {
        if (history.size() > 10) {
            return history.subList(history.size() - 10, history.size());
        }
        return history;
    }

}
