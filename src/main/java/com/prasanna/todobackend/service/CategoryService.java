package com.prasanna.todobackend.service;

import com.prasanna.todobackend.entities.Category;
import com.prasanna.todobackend.repository.CategoryRepository;
import com.prasanna.todobackend.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        categories = categories.stream().map(category -> {
            category.setTodoCount(getTodoCount(category.getCategoryId()));
            return category;
        }).collect(Collectors.toList());
        System.out.println(categories);
        return categories;
    }

    private Long getTodoCount(Long categoryId) {
        Long count = todoRepository.countOfTodos(categoryId);
        return count;
    }
}