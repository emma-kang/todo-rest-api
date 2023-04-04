package com.ekang.todorestapi.service;

import com.ekang.todorestapi.model.TodoDto;
import com.ekang.todorestapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
