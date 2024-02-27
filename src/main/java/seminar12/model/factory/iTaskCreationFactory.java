package seminar12.model.factory;

import seminar12.model.entity.Task;

public interface iTaskCreationFactory {
    Task createTaskWithPriority(Task task);
}
