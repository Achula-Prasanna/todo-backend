package com.prasanna.todobackend.controller;

import com.prasanna.todobackend.entities.Todo;
import com.prasanna.todobackend.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todoapp")
@Api("Todo Api")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping("/todo")
    @ApiOperation(value="Api for getting all the Todo Activities")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity<List<Todo>> getTodos() {
     return null;
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

}
