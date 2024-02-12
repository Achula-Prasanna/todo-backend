package com.prasanna.todobackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long categoryId;
    @Column(name="category_name",nullable = false,unique = true)
    private String categoryName;
    @Column(name="color_code")
    private String colorCode;

    @Transient
    private Long todoCount;

}


