package com.example.TodoApp.controller;

import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class TodoController {
    @Autowired
    TodoService todoService;
    @GetMapping("todos")
    public List<Todo> getAllTodos(){

        return todoService.getAllTodo();
    }
    @ResponseBody
    @GetMapping("todo/done")
    public List<Todo>  getDoneTodos(){

        return todoService.getAllConfirmTodo();
    }
    @GetMapping("todo/undone")
    public List<Todo> getunDoneTodos(){

        return todoService.getAllWattingTodo();
    }
    @PostMapping("todo/add")
    public String addTodo(@RequestBody Todo todo){

        return todoService.addAtodo(todo);
    }
    @PutMapping("todo/markStatus/{todoId}/{status}")
    public String markTodo(@PathVariable Integer todoId, @PathVariable boolean status){
        return todoService.updateStatusOnTodo(todoId,status);
    }
    @DeleteMapping("todo/delete")
    public String removeTodo(@RequestParam Integer todoId){

        return todoService.deleteTodoById(todoId);
    }
}
