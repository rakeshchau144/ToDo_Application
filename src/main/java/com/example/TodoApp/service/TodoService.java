package com.example.TodoApp.service;

import com.example.TodoApp.entity.Todo;
import com.example.TodoApp.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TodoService {
    @Autowired
    TodoRepo todoRepo;

    public TodoService() {

    }
    public List<Todo> getAllTodo(){
        return todoRepo.getMyTodo();
    }

    public List<Todo> getAllConfirmTodo(){
        List<Todo> myDoneTodo=new ArrayList<>();
        for(Todo todo:todoRepo.getMyTodo()){
            if(todo.isTodoDoneStatus()){
                myDoneTodo.add(todo);
            }
        }
        return myDoneTodo;
    }
    public List<Todo> getAllWattingTodo() {
        List<Todo> myUnDoneTodo = new ArrayList<>();
        for (Todo todo : todoRepo.getMyTodo()) {
            if (!todo.isTodoDoneStatus()) {
                myUnDoneTodo.add(todo);
            }
        }
        return myUnDoneTodo;
    }
    public String addAtodo(Todo todo){
        todoRepo.add(todo);
        return "Todo add success full.";
    }
    public String updateStatusOnTodo(Integer todoId, boolean status){
        for(Todo todo:todoRepo.getMyTodo()){
            if(todo.getTodoId().equals(todoId)){
                todo.setTodoDoneStatus(status);
                return "Todo Update Successful .";
            }
        }
        return "Not found TodoId in this todo";
    }
    public String deleteTodoById(Integer todoId){
        for(Todo todo:todoRepo.getMyTodo()){
            if(todo.getTodoId().equals(todoId)){
                todoRepo.delete(todo);
                return "Todo was Deleted.";
            }
        }
        return "Not found TodoId in this todo";
    }

}
