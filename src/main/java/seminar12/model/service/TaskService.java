package seminar12.model.service;

import seminar12.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    List<Task> getTaskByStatus(Task.STATUS status);
    Task createTask(Task task);
    Task updateTask(Long id, Task.STATUS status);
    void deleteTask(Long id);
}
