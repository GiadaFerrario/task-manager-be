package task.manager.taskmanagerbe.service;

import org.springframework.stereotype.Service;
import task.manager.taskmanagerbe.dto.CategoryDTO;
import task.manager.taskmanagerbe.model.Category;
import task.manager.taskmanagerbe.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAll() {
        return categoryRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public CategoryDTO create(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.name());
        category.setDescription(dto.description());
        category.setColor(dto.color());

        Category saved = categoryRepository.save(category);
        return toDTO(saved);
    }

    /*** PRIVATE METHODS ***/
    private CategoryDTO toDTO(Category category) {
        return new CategoryDTO(
                category.getCategoryId(),
                category.getName(),
                category.getDescription(),
                category.getColor()
        );
    }

}
