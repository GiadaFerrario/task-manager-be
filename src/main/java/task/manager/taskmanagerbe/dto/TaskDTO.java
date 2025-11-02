package task.manager.taskmanagerbe.dto;

import task.manager.taskmanagerbe.model.Priority;
import task.manager.taskmanagerbe.model.Status;

public record TaskDTO(Long id,
                      String title,
                      String description,
                      Priority priority,
                      Status status,
                      Long categoryId,
                      String categoryName) {
}
