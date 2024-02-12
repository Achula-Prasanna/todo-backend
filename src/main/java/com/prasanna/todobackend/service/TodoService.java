package com.prasanna.todobackend.service;

import com.prasanna.todobackend.entities.Category;
import com.prasanna.todobackend.entities.Todo;
import com.prasanna.todobackend.repository.CategoryRepository;
import com.prasanna.todobackend.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo saveTodo(Todo todo) {
        log.info("Saving Todo: ",todo);
        return todoRepository.save(todo);
    }

    public List<Todo> getTodosForCategory(Long categoryId) {
        Optional<List<Todo>> todos = todoRepository.findByCategoryId(categoryId);
        if(!todos.isEmpty()) {
            return todos.get();
        } else {
            log.error("No Todo's for the given category");
        }
        return null;
    }

	public Todo updateTodo(Long todoId, Todo todo) throws Exception {
        Optional<Todo> existingTodo = Optional.ofNullable(todoRepository.findById(todoId)
                .orElseThrow(() -> new Exception("Category not found with category: " + todoId)));
        log.info("Updating Todo: {}", existingTodo.get());
        Todo newTodo = existingTodo.get();
        newTodo.setTodoText(todo.getTodoText());
        newTodo.setIsComplete(todo.getIsComplete());
        log.info("Updating Todo2: {}", newTodo);
        return todoRepository.save(newTodo);
    }

 public void deleteTodo(Long todoId) throws Exception {
        Optional<Todo> existingTodo = todoRepository.findById(todoId);
        log.info("existingTodo:{}",existingTodo.get());
        if(existingTodo.isPresent()) {
            todoRepository.deleteById(existingTodo.get().getTodoId());
        } else {
            throw new Exception("Todo with the ID:{} is not found "+todoId);
        }
    }

}
