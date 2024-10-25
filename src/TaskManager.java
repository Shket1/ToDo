import java.util.HashMap;

public interface TaskManager {
    final HashMap<Integer, Task> taskMap = new HashMap<>();
    final HashMap<Integer, Epic> epicMap = new HashMap<>();

    public void getTasks();

    public void removeAll();

    public void getById(int id);

    public void createTask(Task task);

    public void createTask(Epic epic);

    public void updateTask(Task task);

    public void updateTask(Epic epic);

    public void updateTask(Subtask subtask);

    public void removeById(int id);

    public void getSubtaskByEpicId(int id);
}
