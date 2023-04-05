package com.ekang.todorestapi.controller;

import com.ekang.todorestapi.model.TodoDto;
import com.ekang.todorestapi.service.TodoService;
import com.ekang.todorestapi.util.MessageUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;
    private final MessageUtils messageUtils;

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
    public ResponseEntity<?> getTodo(@PathVariable Long todoId) {
        try {
            return ResponseEntity.ok(todoService.getTodoById(todoId));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/todos")
    public ResponseEntity<?> postTodo(@Valid @RequestBody TodoDto todoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(messageUtils.get("server.binding.common.error"));
        }
        try {
            todoService.createTodo(todoDto);
            return ResponseEntity.ok().body(messageUtils.get("server.todo.save_success"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<?> updateTodo(@PathVariable Long todoId, @Valid @RequestBody TodoDto todoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(messageUtils.get("server.binding.common.error"));
        }
        try {
            todoService.getTodoById(todoId);
            todoService.updateTodo(todoDto);
            return ResponseEntity.ok().body(messageUtils.get("server.todo.update_success"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long todoId) {
        try {
            todoService.deleteById(todoId);
            return ResponseEntity.ok().body(messageUtils.get("server.todo.delete_success"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

}
