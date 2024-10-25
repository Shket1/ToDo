public class inMemoryTaskManager implements TaskManager {

    @Override
    public void getTasks() {
        for (Task task : taskMap.values()) {
            System.out.println(task.toString());
        }
        for (Epic epic : epicMap.values()) {
            System.out.println(epic.toString());
        }
    }

    @Override
    public void removeAll() {
        taskMap.clear();

        for (Epic epic : epicMap.values()) {
            epic.getSubtaskMap().clear();
        }

        epicMap.clear();
        System.out.println("Список пуст.");
    }

    @Override
    public void getById(int id) {
        if (taskMap.containsKey(id)) {
            taskMap.get(id);
            Managers.getDefaultHistory().add(taskMap.get(id));
        } else if (epicMap.containsKey(id)) {
            epicMap.get(id);
            Managers.getDefaultHistory().add(epicMap.get(id));
        }
    }

    @Override
    public void createTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public void createTask(Epic epic) {
        epicMap.put(epic.getId(), epic);
    }

    @Override
    public void updateTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public void updateTask(Epic epic) {
        epicMap.put(epic.getId(), epic);
    }

    @Override
    public void updateTask(Subtask subtask) {
        for (Epic epic : epicMap.values()) {
            if (epic.getSubtaskMap().containsKey(subtask.getId())) {
                epic.getSubtaskMap().put(subtask.getId(), subtask);
                epic.update();
            }
        }
    }

    @Override
    public void removeById(int id) {
        taskMap.remove(id);
        epicMap.remove(id);
    }

    @Override
    public void getSubtaskByEpicId(int id) {
        for (Subtask subtask : epicMap.get(id).getSubtaskMap().values()) {
            System.out.println(subtask.toString());
        }
    }
}
