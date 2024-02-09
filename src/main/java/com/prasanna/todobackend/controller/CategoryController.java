package com.prasanna.todobackend.controller;

import com.prasanna.todobackend.entities.Category;
import com.prasanna.todobackend.entities.Todo;
import com.prasanna.todobackend.service.CategoryService;
import com.prasanna.todobackend.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todoapp")
@Api("Todo App Api")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/category")
    @ApiOperation(value="Api for getting all the Categories")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getCategories();
        log.info("Categories:",categories);
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/category")
    @ApiOperation(value="Api for saving Category type")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return ResponseEntity.ok(category);
    }

}
