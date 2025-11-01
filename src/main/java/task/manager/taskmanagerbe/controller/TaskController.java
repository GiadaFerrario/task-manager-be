package task.manager.taskmanagerbe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.manager.taskmanagerbe.dto.TaskDTO;
import task.manager.taskmanagerbe.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO task) {
        TaskDTO saved = taskService.create(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
