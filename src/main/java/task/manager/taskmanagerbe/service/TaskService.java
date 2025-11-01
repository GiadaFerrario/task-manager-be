package task.manager.taskmanagerbe.service;

import org.springframework.stereotype.Service;
import task.manager.taskmanagerbe.dto.TaskDTO;
import task.manager.taskmanagerbe.model.Task;
import task.manager.taskmanagerbe.repository.CategoryRepository;
import task.manager.taskmanagerbe.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;


    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<TaskDTO> getAll() {
        return taskRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public TaskDTO create(TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setPriority(dto.priority());
        task.setCategory(categoryRepository.findById(dto.categoryId()).orElse(null));

        Task saved = taskRepository.save(task);
        return toDTO(saved);
    }

    /*** PRIVATE METHODS ***/
    private TaskDTO toDTO(Task task) {
        return new TaskDTO(
                task.getTaskId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getCategory() != null ? task.getCategory().getCategoryId() : null,
                task.getCategory() != null ? task.getCategory().getName() : null
        );
    }

}
