package com.prasanna.todobackend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="todo_id")
    private Long todoId;
    @Column(name="todo_text")
    private String todoText;
    @Column(name="todo_status")
    private Boolean isComplete;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
