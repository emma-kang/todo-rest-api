package com.ekang.todorestapi.entity;

import com.ekang.todorestapi.model.TodoDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "todo")
public class Todo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false, length = 1000)
    private String task;

    @Column(nullable = false)
    private Boolean completed;

    public static Todo createInstance(Long accountId, String task, Boolean completed) {
        Todo todo = new Todo();
        todo.accountId = accountId;
        todo.task = task;
        todo.completed = completed;
        return todo;
    }

    public void updateTodo(TodoDto todoDto) {
        task = todoDto.getTask();
        completed = todoDto.getCompleted();
    }
}
