package seminar12.model.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar12.model.entity.Task;
import seminar12.model.service.TaskService;

@Service("normal")
public class NormalPriorityTask implements iTaskCreationFactory {
    @Autowired
    private TaskService taskService;

    @Override
    public Task createTaskWithPriority(Task task) {
        task.setPriority(Task.PRIORITY.NORMAL);
        return taskService.createTask(task);
    }
}
