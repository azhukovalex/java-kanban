package main.taskManager;

import main.models.EpicTask;
import main.models.SubTask;
import main.models.Task;

import java.util.HashMap;
import java.util.List;

public interface TaskManager {

    Task saveSingleTask(Task singleTask);

    void updateSingleTask(Task singleTask);

    Task getSingleTaskById(Integer taskId);

    void deleteSingleTask(Integer taskId);

    SubTask saveSubTask(SubTask subTask);

    void updateSubTask(SubTask subTask);
    Task getSubTaskById(Integer taskId);

    void deleteSubTaskById(Integer subTaskId);

    Task saveEpicTask(Task epicTask);
    void updateEpicTask(EpicTask epicTask);
    Task getEpicTaskById(Integer epicId);

    void deleteEpicTaskById(Integer epicId);
    List<SubTask> getEpicSubTasksById(Integer epicId);

    List<Task> getAllSingleTask();
    List<Task> getAllSubTasks();
    List<Task> getAllEpicTask();

    void deleteAllSingleTask();
    void deleteAllSubTask();
    void deleteAllEpicTask();

    List<Task> getHistory();

    HashMap<Integer, Task> getTasks();

}
