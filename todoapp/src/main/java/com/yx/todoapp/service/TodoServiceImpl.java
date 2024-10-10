package com.yx.todoapp.service;

import com.yx.todoapp.dao.TodoRepository;
import com.yx.todoapp.domain.Todo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Resource
    private TodoRepository todoRepository;
    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo createTodo(Todo todo) {

        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo updateTodo) {

        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(updateTodo.getTitle());
                    todo.setCompleted(updateTodo.getCompleted());
                    return todoRepository.save(todo);
                }).orElseGet(() ->{
                    updateTodo.setId(id);
                    return todoRepository.save(updateTodo);
                });
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
