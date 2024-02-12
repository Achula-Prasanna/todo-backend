package com.prasanna.todobackend.repository;

import com.prasanna.todobackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query(value = "select * from Category c where c.category_name=:categoryName",nativeQuery = true)
    Optional<Category> findByCategoryName(String categoryName);

    @Query(value="update category c set c.category_name=:newName where c.category_name=:oldName",nativeQuery = true)
    Optional<Category> updateCategoryByName(String oldName,String newName);
}
