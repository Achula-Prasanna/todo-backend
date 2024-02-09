package com.prasanna.todobackend.repository;

import com.prasanna.todobackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("select c.category from Category c where c.category=:categoryName")
    Category findByCategoryName(String categoryName);
}
