import java.util.HashMap;

public class Epic extends Task{

    private final HashMap<Integer, Subtask> subtaskMap = new HashMap<>();

    public Epic(String nameTask, String subscription) {
        super(nameTask, subscription);
    }

    public HashMap<Integer, Subtask> getSubtaskMap() {
        return subtaskMap;
    }

    public void addSubtask(Subtask subtask) {
        this.subtaskMap.put(subtask.getId(), subtask);
    }

    public void update() {
        int count = 0;
        if (subtaskMap.isEmpty()) {
            this.setStatus(Status.NEW);
            return;
        }

        for (Subtask subtask : subtaskMap.values()) {
            if (subtask.getStatus() == Status.DONE) {
                count++;
            } else if (subtask.getStatus() == Status.NEW) {
                count--;
            }
        }
        if (count == subtaskMap.size()) {
            this.setStatus(Status.DONE);
        } else if (count == (-subtaskMap.size())) {
            this.setStatus(Status.NEW);
        } else {
            this.setStatus(Status.IN_PROGRESS);
        }

    }
}
