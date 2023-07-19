package com.example.TodoApp;

import com.example.TodoApp.entity.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Beanfactory {
    @Bean
    public List<Todo> getDataSource(){
        return new ArrayList<>();
    }
}
