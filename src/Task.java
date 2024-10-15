public class Task {
    private String nameTask;
    private String subscription;
    private int id;
    private Status status = Status.NEW;
    private static int idTask = 1;

    public Task(String nameTask, String subscription) {
        this.nameTask = nameTask;
        this.subscription = subscription;
        this.id = idTask++;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static int getIdTask() {
        return idTask;
    }

    public static void setIdTask(int idTask) {
        Task.idTask = idTask;
    }

    @Override
    public String toString() {
        return "Задача{" +
                "Название: " + nameTask + '\'' +
                ", Описание: " + subscription + '\'' +
                ", id: " + id +
                ", Статус: " + status +
                '}';
    }
}
