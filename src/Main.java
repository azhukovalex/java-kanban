import models.*;

public class Main {

    public static void main(String[] args) {
        String newLine = System.getProperty("line.separator");
        TaskManager taskManager = new TaskManager();
        //Создайте две задачи, а также эпик с двумя подзадачами и эпик с одной подзадачей.
        Task task1 = taskManager.createTask(new Task("Задача1", "Описание1"));
        Task task2 = taskManager.createTask(new Task("Задача2", "Описание2"));

        Epic epic1 = taskManager.createEpic(new Epic("Эпик1", "Описание эпика 1"));

        SubTask subTask1 = taskManager.createSubTask(new SubTask("Подзадача1 Эпика1", "Описание подзадачи1 Эпика1", epic1.getId()));
        SubTask subTask2 = taskManager.createSubTask(new SubTask("Подзадача2 Эпика1", "Описание подзадачи2 Эпика1", epic1.getId()));

        Epic epic2 = taskManager.createEpic(new Epic("Эпик2", "Описание эпика 2"));
        SubTask subTask3 = taskManager.createSubTask(new SubTask("Подзадача1 Эпика2", "Описание подзадачи1 Эпика2", epic2.getId()));

        //Распечатайте списки эпиков, задач и подзадач через System.out.println(..)\

        System.out.println(taskManager.getAllEpics()); //эпики
        System.out.println(newLine);
         System.out.println(taskManager.getAllSubTasks()); //подзадачи
        System.out.println(newLine);
        System.out.println(taskManager.getAllTasks());//задачи
        System.out.println(newLine);

        //Измените статусы созданных объектов, распечатайте их. Проверьте, что статус задачи и подзадачи сохранился, а статус эпика рассчитался по статусам подзадач.
        taskManager.updateTask(new Task(task1.getId(), task1.getTitle(), task1.getDescription(), TaskStates.IN_PROGRESS)); //смена статуса задачи1
        taskManager.updateTask(new Task(task2.getId(), task2.getTitle(), task2.getDescription(), TaskStates.DONE)); //смена статуса задачи2
        System.out.println(taskManager.getTask(task1.getId()));
        System.out.println(newLine);
        System.out.println(taskManager.getTask(task2.getId()));
        System.out.println(newLine);

        taskManager.updateSubTask(new SubTask(subTask1.getId(), subTask1.getTitle(), subTask1.getDescription(), TaskStates.DONE, subTask1.getEpicId()));
        taskManager.updateSubTask(new SubTask(subTask2.getId(), subTask2.getTitle(), subTask2.getDescription(), TaskStates.DONE, subTask2.getEpicId()));
        taskManager.updateSubTask(new SubTask(subTask3.getId(), subTask3.getTitle(), subTask3.getDescription(), TaskStates.DONE, subTask3.getEpicId()));

        System.out.println(taskManager.getSubTask(subTask1.getId()));
        System.out.println(newLine);
        System.out.println(taskManager.getSubTask(subTask2.getId()));
        System.out.println(newLine);
        System.out.println(taskManager.getEpic(epic1.getId()));
        System.out.println(newLine);
        System.out.println(taskManager.getSubTask(subTask3.getId()));
        System.out.println(newLine);
        System.out.println(taskManager.getEpic(epic2.getId()));

        //И, наконец, попробуйте удалить одну из задач и один из эпиков.
        taskManager.deleteTask(task2.getId());
        taskManager.deleteEpic(epic2.getId());
        taskManager.deleteSubTask(subTask1.getId());

        System.out.println(taskManager.getAllEpics());
        System.out.println(newLine);
        System.out.println(taskManager.getAllTasks());
        System.out.println(newLine);
        System.out.println(taskManager.getAllSubTasks());
    }
}