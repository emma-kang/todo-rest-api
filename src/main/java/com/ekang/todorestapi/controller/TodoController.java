package com.ekang.todorestapi.controller;

import com.ekang.todorestapi.model.TodoDto;
import com.ekang.todorestapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<?> getAllTodos(@RequestParam(required = false) Long accountId) {
        try {
            if (accountId != null && accountId > 0) return ResponseEntity.ok(todoService.getTodosByUser(accountId));
            return ResponseEntity.ok(todoService.getAllTodos());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<?> getTodos(@PathVariable Long todoId) {
        return ResponseEntity.ok().body("update todo id=" + todoId);
    }

    @PostMapping("/todos")
    public ResponseEntity<?> postTodo(@RequestBody TodoDto todoDto) {
        return ResponseEntity.ok().body("todos");
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long todoId) {
        return ResponseEntity.ok().body("delete todo id=" + todoId);
    }

}
