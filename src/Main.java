public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

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

        manager.createTask(task1);
        manager.createTask(task2);

        manager.createTask(epic1);
        manager.createTask(epic2);

        subtask1.setStatus(Status.DONE);
        subtask2.setStatus(Status.IN_PROGRESS);
        manager.updateTask(subtask1);
        manager.updateTask(subtask2);

        task1.setStatus(Status.IN_PROGRESS);
        manager.updateTask(task1);

        manager.getTasks();
        System.out.println("________________________________________________________________________");

        manager.removeById(2);

        manager.getTasks();
    }
}