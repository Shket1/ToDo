public class Managers {

    private final TaskManager task = new inMemoryTaskManager();
    private static final HistoryManager history = new InMemoryHistoryManager();

    public TaskManager getDefault() {
        return task;
    }

    public static HistoryManager getDefaultHistory() {
        return history;
    }
}
