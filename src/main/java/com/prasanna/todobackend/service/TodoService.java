package com.prasanna.todobackend.service;

import com.prasanna.todobackend.entities.Category;
import com.prasanna.todobackend.entities.Todo;
import com.prasanna.todobackend.repository.CategoryRepository;
import com.prasanna.todobackend.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Todo> getTodosForCategory(String category) {
        List<Todo> todos = todoRepository.findByCategoryName(category);
        return todos;
    }

}
