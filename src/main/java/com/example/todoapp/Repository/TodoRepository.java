package com.example.todoapp.Repository;

import com.example.todoapp.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
    List<Todo> findAll();
    Todo findById(int id);
    Todo deleteById(int id);
    //void updateById(int id);
    //Todo updateById(Todo todo);

}
