import java.util.HashMap;

public class Manager {

    private final HashMap<Integer, Task> taskMap = new HashMap<>();
    private final HashMap<Integer, Epic> epicMap = new HashMap<>();

    public void getTasks() {
        for (Task task : taskMap.values()) {
            System.out.println(task.toString());
        }
        for (Epic epic : epicMap.values()) {
            System.out.println(epic.toString());
        }
    }

    public void removeAll() {
        taskMap.clear();

        for (Epic epic : epicMap.values()) {
            epic.getSubtaskMap().clear();
        }

        epicMap.clear();
        System.out.println("Список пуст.");
    }

    public void getById(int id) {
        if (taskMap.containsKey(id)) {
            taskMap.get(id);
        } else if (epicMap.containsKey(id)) {
            epicMap.get(id);
        }
    }

    public void createTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void createTask(Epic epic) {
        epicMap.put(epic.getId(), epic);
    }

    public void updateTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void updateTask(Epic epic) {
        epicMap.put(epic.getId(), epic);
    }

    public void updateTask(Subtask subtask) {
        for (Epic epic : epicMap.values()) {
            if (epic.getSubtaskMap().containsKey(subtask.getId())) {
                epic.getSubtaskMap().put(subtask.getId(), subtask);
                epic.update();
            }
        }
    }

    public void removeById(int id) {
        taskMap.remove(id);
        epicMap.remove(id);
    }

    public void getSubtaskByEpicId(int id) {
        for (Subtask subtask : epicMap.get(id).getSubtaskMap().values()) {
            System.out.println(subtask.toString());
        }
    }
}
