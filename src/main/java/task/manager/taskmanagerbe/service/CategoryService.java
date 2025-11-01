package task.manager.taskmanagerbe.service;

import org.springframework.stereotype.Service;
import task.manager.taskmanagerbe.model.Category;
import task.manager.taskmanagerbe.model.Task;
import task.manager.taskmanagerbe.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }
}
