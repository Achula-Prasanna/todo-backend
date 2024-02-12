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
import org.springframework.http.HttpStatus;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/category/{id}")
    @ApiOperation(value="Api for getting all the Categories")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.getCategory(categoryId);
        return ResponseEntity.ok(category);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/category")
    @ApiOperation(value="Api for saving Category type")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/category/{categoryId}")
    @ApiOperation(value="Api for updating Category type")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody String updatedName) {
        Category category =  null;
        try {
            category = categoryService.updateCategory(categoryId,updatedName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(category);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/category/{categoryId}")
    @ApiOperation(value="Api for Deleting Category")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Ok"),
            @ApiResponse(code=401,message="UnAuthorized")

    })
    public ResponseEntity deleteCategory(@PathVariable("categoryId") Long categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

}
