package task.manager.taskmanagerbe.dto;

import task.manager.taskmanagerbe.model.Priority;

public record CategoryDTO(Long id,
                          String name,
                          String description,
                          String color) {
}
