package seminar12.controller;

import org.springframework.web.bind.annotation.*;
import seminar12.model.entity.Task;
import seminar12.model.factory.TaskCreationFactoryImpl;
import seminar12.model.service.TaskService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;
    private final TaskCreationFactoryImpl taskCreationFactoryImpl;


    public TaskController(TaskService service, TaskCreationFactoryImpl taskCreationFactoryImpl) {
        this.service = service;
        this.taskCreationFactoryImpl = taskCreationFactoryImpl;
    }


    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @GetMapping("/stat/{status}")
    public List<Task> getTaskByStatus(@PathVariable Task.STATUS status) {
        return service.getTaskByStatus(status);
    }

    @PostMapping("/{priority}")
    public Task createTaskWithPriority(@PathVariable String priority,
                                       @RequestBody Task task)
    {
        try {
            return taskCreationFactoryImpl.getService(priority).createTaskWithPriority(task);
        } catch (NullPointerException ex){
            throw new RuntimeException("Invalid priority!");
        }
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestParam Task.STATUS status) {
        return service.updateTask(id, status);
    }


    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
