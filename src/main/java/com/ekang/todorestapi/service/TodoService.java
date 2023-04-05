package com.ekang.todorestapi.service;

import com.ekang.todorestapi.entity.Todo;
import com.ekang.todorestapi.exception.TodoHttpResponse;
import com.ekang.todorestapi.exception.TodoResponseStatusException;
import com.ekang.todorestapi.model.TodoDto;
import com.ekang.todorestapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(TodoDto::createInstance)
                .collect(Collectors.toList());
    };

    public List<TodoDto> getTodosByUser(Long accountId) {
        return todoRepository.findAllWithUserId(accountId).stream().map(TodoDto::createInstance).collect(Collectors.toList());
    }

    public TodoDto getTodoById(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new TodoResponseStatusException(TodoHttpResponse.SC_NOT_FOUND));
        return TodoDto.createInstance(todo);
    }

    @Transactional
    public void createTodo(TodoDto todoDto) {
        Todo newTodo = Todo.createInstance(todoDto.getAccountId(), todoDto.getTask(), todoDto.getCompleted());
        todoRepository.save(newTodo);
    }

    @Transactional
    public void updateTodo(TodoDto todoDto) {
        Todo todo = todoRepository.findById(todoDto.getId()).orElseThrow();
        todo.updateTodo(todoDto);
    }

    @Transactional
    public void deleteById(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow();
        todoRepository.deleteById(todo.getId());
    }
}
