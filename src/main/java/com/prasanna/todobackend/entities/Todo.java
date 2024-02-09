package com.prasanna.todobackend.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="todo_id")
    private Integer todoId;
    @Column(name="todo_text")
    private String todoText;
    @Column(name="todo_status")
    private Boolean isComplete;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
