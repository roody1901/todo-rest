package com.example.todoapp.Controller;

import com.example.todoapp.Repository.TodoRepository;
import com.example.todoapp.Entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepo;

    @PostMapping("/todo/add")
    public void addTodo(@RequestBody Todo todo){ //requestBoody is need for saving data because in that we get the send data
        todoRepo.save(todo);
    }

    @GetMapping("/todo/get")
    public List<Todo> getTodo(){
        return todoRepo.findAll();
    }

    @PutMapping("/todo/update/{id}")
    public Todo updtTodo(@PathVariable int id, @RequestBody Todo todo) {
        Todo temp = todoRepo.findById(id);
//                .orElseThrow(() -> new RuntimeException("Not found"));
        if (temp != null) {
       //  todoRepo.updateById(todo);
            temp.setDescription(todo.getDescription());
            temp.setName(todo.getName());
        }
        return todoRepo.save(temp);
    }

@DeleteMapping("/todo/del/{id}")
    public Todo delTodo(@PathVariable int id){
        todoRepo.deleteById(id);
        return (Todo) todoRepo.findAll();
    }




}
