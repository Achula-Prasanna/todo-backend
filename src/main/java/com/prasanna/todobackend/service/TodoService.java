package com.prasanna.todobackend.service;

import com.prasanna.todobackend.entities.Category;
import com.prasanna.todobackend.entities.Todo;
import com.prasanna.todobackend.repository.CategoryRepository;
import com.prasanna.todobackend.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Todo saveTodo(Todo todo) {
        log.info("Saving Todo: ",todo);
        return todoRepository.save(todo);
    }

    public Category saveCategory(Category category) {
        log.info("Saving Category: ",category);
        return categoryRepository.save(category);
    }
}
