package com.example.TodoApp.repository;

import com.example.TodoApp.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepo {
    @Autowired
    private List<Todo> myTodo;

    public List<Todo> getMyTodo(){

        return myTodo;
    }
    public void add(Todo todo)
    {
        myTodo.add(todo);
    }

    public void delete(Todo todo)
    {
        myTodo.remove(todo);
    }

}
