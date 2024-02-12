package com.prasanna.todobackend.controller;

import com.prasanna.todobackend.entities.Todo;
import com.prasanna.todobackend.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todoapp")
@Api("Todo Api")
@CrossOrigin(origins = "*")
@Slf4j
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todo/{categoryId}")
    @ApiOperation(value="Api for getting all the Todo Activities")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity<List<Todo>> getTodos(@PathVariable("categoryId") Long categoryId) {
        List<Todo> todos = todoService.getTodosForCategory(categoryId);
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/todo")
    @ApiOperation(value="Api for saving Todo Activity")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity saveTodo(@RequestBody Todo todo) {
        todoService.saveTodo(todo);
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/todo/{todoId}")
    @ApiOperation(value="Api for updating Todo type")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity<Todo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody Todo updatedTodo) {
        Todo todo =  null;
        try {
            todo = todoService.updateTodo(todoId,updatedTodo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/todo/{todoId}")
    @ApiOperation(value="Api for Deleting Todo")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity deleteTodo(@PathVariable("todoId") Long todoId) {
        try {
            todoService.deleteTodo(todoId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
