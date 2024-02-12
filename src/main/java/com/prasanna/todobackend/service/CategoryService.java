package com.prasanna.todobackend.service;

import com.prasanna.todobackend.entities.Category;
import com.prasanna.todobackend.repository.CategoryRepository;
import com.prasanna.todobackend.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TodoRepository todoRepository;

    public Category saveCategory(Category category) {
        log.info("Saving Category: ",category);
        return categoryRepository.save(category);
    }
    public Category updateCategory(Long categoryId, String categoryName) throws Exception {
        Optional<Category> existingCategory = Optional.ofNullable(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new Exception("Category not found with category: " + categoryId)));
        log.info("Updating Category1: {}", existingCategory.get());
        Category newCategory = existingCategory.get();
        newCategory.setCategoryName(categoryName);
        log.info("Updating Category2: {}", newCategory);
        return categoryRepository.save(newCategory);
    }

    public void deleteCategory(Long categoryId) throws Exception {
        Optional<Category> existingCategory = categoryRepository.findById(categoryId);
        if(existingCategory.isPresent()) {
            categoryRepository.deleteById(existingCategory.get().getCategoryId());
        } else {
            throw new Exception("Category with the ID:{} is not found"+categoryId);
        }
    }

    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        categories = categories.stream().map(category -> {
            category.setTodoCount(getTodoCount(category.getCategoryId()));
            return category;
        }).collect(Collectors.toList());
        System.out.println(categories);
        return categories;
    }

    public Category getCategory(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.get();
    }

    private Long getTodoCount(Long categoryId) {
        Long count = todoRepository.countOfTodos(categoryId);
        return count;
    }
}