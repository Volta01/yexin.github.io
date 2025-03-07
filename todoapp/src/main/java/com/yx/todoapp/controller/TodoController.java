package com.yx.todoapp.controller;

import com.yx.todoapp.domain.Todo;
import com.yx.todoapp.service.TodoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Resource
    private TodoService todoService;
    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }
    @PostMapping
    public Todo createTodo(@RequestBody  Todo todo){
        return todoService.createTodo(todo);

    }
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable long id,@RequestBody Todo updateTodo){
        return todoService.updateTodo(id, updateTodo);
    }
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable long id){
        todoService.deleteTodo(id);
    }
}
