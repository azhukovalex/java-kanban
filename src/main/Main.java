package main;

import main.models.SingleTask;
import main.models.Status;
import main.models.SubTask;
import main.models.Task;
import main.taskManager.Managers;
import main.taskManager.TaskManager;
import main.models.EpicTask;

public class Main {
    static String newLine = System.lineSeparator();
    public static void main(String[] args) {

        TaskManager taskManager = Managers.getDefault();
        //Создайте две задачи, а также эпик с двумя подзадачами и эпик с одной подзадачей.
        Task task1 = taskManager.saveSingleTask(new SingleTask("Задача1", "Описание1"));
        Task task2 = taskManager.saveSingleTask(new Task("Задача2", "Описание2"));

        Task epic1 = taskManager.saveEpicTask(new EpicTask("Эпик1", "Описание эпика 1"));

        SubTask subTask1 = taskManager.saveSubTask(new SubTask("Подзадача1 Эпика1", "Описание подзадачи1 Эпика1", epic1.getId()));
        SubTask subTask2 = taskManager.saveSubTask(new SubTask("Подзадача2 Эпика1", "Описание подзадачи2 Эпика1", epic1.getId()));

        Task epic2 = taskManager.saveEpicTask(new EpicTask("Эпик2", "Описание эпика 2"));
        SubTask subTask3 = taskManager.saveSubTask(new SubTask("Подзадача1 Эпика2", "Описание подзадачи1 Эпика2", epic2.getId()));

        //Распечатайте списки эпиков, задач и подзадач через System.out.println(..)\
        System.out.println("Эпики");
        System.out.println(taskManager.getAllEpicTask()); //эпики
        System.out.println(newLine);

        System.out.println("Подзадачи");
         System.out.println(taskManager.getAllSubTasks()); //подзадачи
        System.out.println(newLine);

        System.out.println("Задачи");
        System.out.println(taskManager.getAllSingleTask());//задачи
        System.out.println(newLine);

        //Измените статусы созданных объектов, распечатайте их. Проверьте, что статус задачи и подзадачи сохранился, а статус эпика рассчитался по статусам подзадач.
        taskManager.updateSingleTask(new Task(task1.getId(), task1.getTitle(), task1.getDescription(), Status.IN_PROGRESS)); //смена статуса задачи1
        taskManager.updateSingleTask(new Task(task2.getId(), task2.getTitle(), task2.getDescription(), Status.DONE)); //смена статуса задачи2
        System.out.println("смена статуса задачи1");
        System.out.println(taskManager.getSingleTaskById(task1.getId()));
        System.out.println(newLine);
        System.out.println("смена статуса задачи2");
        System.out.println(taskManager.getSingleTaskById(task2.getId()));
        System.out.println(newLine);

        taskManager.updateSubTask(new SubTask(subTask1.getId(), subTask1.getTitle(), subTask1.getDescription(), Status.DONE, subTask1.getEpicId()));
        taskManager.updateSubTask(new SubTask(subTask2.getId(), subTask2.getTitle(), subTask2.getDescription(), Status.DONE, subTask2.getEpicId()));
        taskManager.updateSubTask(new SubTask(subTask3.getId(), subTask3.getTitle(), subTask3.getDescription(), Status.IN_PROGRESS, subTask3.getEpicId()));

        System.out.println("смена статуса подзадачи1");
        System.out.println(taskManager.getSubTaskById(subTask1.getId()));
        System.out.println(newLine);
        System.out.println("смена статуса подзадачи2");
        System.out.println(taskManager.getSubTaskById(subTask2.getId()));
        System.out.println(newLine);
        System.out.println("смена статуса эпика1");
        System.out.println(taskManager.getEpicTaskById(epic1.getId()));
        System.out.println(newLine);
        System.out.println("смена статуса подзадачи3");
        System.out.println(taskManager.getSubTaskById(subTask3.getId()));
        System.out.println(newLine);
        System.out.println("смена статуса эпика2");
        System.out.println(taskManager.getEpicTaskById(epic2.getId()));

        //И, наконец, попробуйте удалить одну из задач и один из эпиков.
        taskManager.deleteSingleTask(task2.getId());
        taskManager.deleteEpicTaskById(epic2.getId());
        taskManager.deleteSubTaskById(subTask1.getId());
        System.out.println("Эпики после удаления эпика2");
        System.out.println(taskManager.getAllEpicTask());
        System.out.println(newLine);
        System.out.println("Задачи после удаления задачи2");
        System.out.println(taskManager.getAllSingleTask());
        System.out.println(newLine);
        System.out.println("Подзадачи после удаления подзадачи1");
        System.out.println(taskManager.getAllSubTasks());
    }
}