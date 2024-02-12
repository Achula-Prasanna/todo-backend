package com.prasanna.todobackend.repository;

import com.prasanna.todobackend.entities.Category;
import com.prasanna.todobackend.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    @Query(value = "SELECT * FROM todo t INNER JOIN category c ON t.category_id = c.category_id WHERE c.category_name = :categoryName", nativeQuery = true)
    List<Todo> findByCategoryName(String categoryName);

    @Query(value = "SELECT * FROM todo t where t.category_id = :categoryId", nativeQuery = true)
    Optional<List<Todo>> findByCategoryId(Long categoryId);
    @Query(value = "SELECT COUNT(*) FROM todo t where t.category_id=:categoryId", nativeQuery = true)
    Long countOfTodos(Long categoryId);
}
