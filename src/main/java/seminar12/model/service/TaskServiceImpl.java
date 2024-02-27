package seminar12.model.service;

import org.springframework.stereotype.Service;
import seminar12.model.entity.Task;
import seminar12.model.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Override
    public List<Task> getTaskByStatus(Task.STATUS status){
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task.STATUS status) {
        Task existingTask = getTaskById(id);
        existingTask.setStatus(status);
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        getTaskById(id);
        taskRepository.deleteById(id);
    }


}
