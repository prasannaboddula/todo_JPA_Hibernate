package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoJpaService;

@RestController
public class TodoController{

    @Autowired
    public TodoJpaService todoService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos(){
        return todoService.getTodos();
    }
    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int todoId){
        return todoService.getTodoById(todoId);
    }
    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int todoId, @RequestBody Todo todo){
        return todoService.updateTodo(todoId, todo);
    }
    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") int todoId){
        todoService.deleteTodo(todoId);
    }
}