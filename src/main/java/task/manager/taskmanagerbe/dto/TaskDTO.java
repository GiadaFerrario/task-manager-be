package task.manager.taskmanagerbe.dto;

import task.manager.taskmanagerbe.model.Priority;

public record TaskDTO(Long id,
                      String title,
                      String description,
                      Priority priority,
                      Long categoryId,
                      String categoryName) {
}
