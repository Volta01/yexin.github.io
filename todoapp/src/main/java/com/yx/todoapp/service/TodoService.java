package com.yx.todoapp.service;

import com.yx.todoapp.domain.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo createTodo(Todo todo);
    Todo updateTodo(Long id,Todo updateTodo);
    void deleteTodo(Long id);

}
