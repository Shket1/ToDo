public class Main {
    public static void main(String[] args) {
        inMemoryTaskManager inMemoryTaskManager = new inMemoryTaskManager();
        Managers manager = new Managers();

        Task task1 = new Task("Task1", "go to home");
        Task task2 = new Task("Task2", "go to street");

        Epic epic1 = new Epic("Перезд", "Переехать в другую квартиру");
        Epic epic2 = new Epic("Переход", "Перейти реку");

        Subtask subtask1 = new Subtask("Сбор", "Собрать вещи");
        Subtask subtask2 = new Subtask("Сбор", "Найти машину");
        Subtask subtask3 = new Subtask("Поиск", "Найти мост");

        epic1.addSubtask(subtask1);
        epic1.addSubtask(subtask2);
        epic2.addSubtask(subtask3);

        inMemoryTaskManager.createTask(task1);
        inMemoryTaskManager.createTask(task2);

        inMemoryTaskManager.createTask(epic1);
        inMemoryTaskManager.createTask(epic2);

        subtask1.setStatus(Status.DONE);
        subtask2.setStatus(Status.IN_PROGRESS);
        inMemoryTaskManager.updateTask(subtask1);
        inMemoryTaskManager.updateTask(subtask2);

        task1.setStatus(Status.IN_PROGRESS);
        inMemoryTaskManager.updateTask(task1);

        inMemoryTaskManager.getTasks();
        System.out.println("________________________________________________________________________");

        inMemoryTaskManager.getTasks();

        inMemoryTaskManager.getById(2);
        inMemoryTaskManager.getById(3);
        inMemoryTaskManager.getById(2);

        System.out.println("---History---");
        Managers.getDefaultHistory().getHistory();
    }
}