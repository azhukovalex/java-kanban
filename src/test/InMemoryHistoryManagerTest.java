package test;

import main.models.Status;
import main.models.Task;
import main.taskManager.HistoryManager;
import main.taskManager.Managers;
import main.taskManager.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryHistoryManagerTest {
    private HistoryManager taskHistoryManager;
    private TaskManager taskManager;
    private Task task1;
    private Task task2;
    private Task task3;


    @BeforeEach
    void setUp() {
        taskManager = Managers.getDefault();
        taskHistoryManager = Managers.getDefaultHistory();
        task1 = new Task(1, "task_1", "Sdelat task_1", Status.NEW);
        task2 = new Task(2, "task_2", "Sdelat task_2", Status.NEW);
        task3 = new Task(3, "task_3", "Sdelat task_3", Status.NEW);
    }

    @Test
    void addInHistoryManager() {
        //пустая история
        List<Task> history = taskHistoryManager.getHistory();
        assertEquals(0,history.size(), "История не пустая.");

        //дублирование
        taskHistoryManager.add(task1);
        taskHistoryManager.add(task1);

        history = taskHistoryManager.getHistory();
        assertEquals(1, history.size(), "История не допускает дублирование файлов.");
    }

    @Test
    void removeFirstElementInHistoryManager() {
        taskHistoryManager.add(task1);
        taskHistoryManager.add(task2);
        taskHistoryManager.add(task3);

        taskHistoryManager.remove(task1.getId());
        assertEquals(List.of(task2,task3), taskHistoryManager.getHistory(), "Задачи в порядке вызоыв в истории");
    }

    @Test
    void removeLastElementInHistoryManager() {
        taskHistoryManager.add(task1);
        taskHistoryManager.add(task2);
        taskHistoryManager.add(task3);

        taskHistoryManager.remove(task3.getId());
        assertEquals(List.of(task1,task2), taskHistoryManager.getHistory(), "Задачи в порядке вызоыв в истории");
    }

    @Test
    void removeMiddleElementInHistoryManager() {
        taskHistoryManager.add(task1);
        taskHistoryManager.add(task2);
        taskHistoryManager.add(task3);

        taskHistoryManager.remove(task2.getId());
        assertEquals(List.of(task1,task3), taskHistoryManager.getHistory(), "Задачи в порядке вызоыв в истории");
    }
}
