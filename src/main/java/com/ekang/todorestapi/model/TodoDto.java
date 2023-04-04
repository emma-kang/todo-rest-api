package com.ekang.todorestapi.model;

import com.ekang.todorestapi.entity.Todo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoDto {
    private Long id;
    private Long accountId;
    private String task;
    private Boolean completed;

    public static TodoDto createInstance(Todo todo) {
        TodoDto rValue = new TodoDto();
        rValue.id = todo.getId();
        rValue.accountId = todo.getAccountId();
        rValue.task = todo.getTask();
        rValue.completed = todo.getCompleted();
        return rValue;
    }
}
