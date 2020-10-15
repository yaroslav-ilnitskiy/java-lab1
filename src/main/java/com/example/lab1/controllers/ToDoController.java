package com.example.lab1.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.lab1.dto.ResponseInfo;
import com.example.lab1.entities.ToDo;
import com.example.lab1.services.ToDoService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "*")
@RestController
public class ToDoController {
    @Autowired
    private ToDoService service;

    @GetMapping("/todo")
    public List<ToDo> all() {
        return service.findAll();
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<ToDo> get(@PathVariable Integer id) {
        try {
            ToDo todo = service.find(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todo")
    public ResponseEntity<ToDo> add(@RequestBody ToDo toDo) {
        toDo.setCreatedAt(LocalDateTime.now());
        service.save(toDo);

        return new ResponseEntity<>(toDo, HttpStatus.OK);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<?> update(@RequestBody ToDo toDo, @PathVariable Integer id) {
        try {
            ToDo existToDo = service.find(id);

            existToDo.setDescription(toDo.getDescription());
            existToDo.setIsFinished(toDo.getIsFinished());
            service.save(existToDo);

            return new ResponseEntity<>(toDo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/todo/{id}")
    public ResponseInfo delete(@PathVariable Integer id) {
        try {
            service.delete(id);

            return new ResponseInfo();
        } catch (EmptyResultDataAccessException e) {
            return new ResponseInfo(false, "ToDo not found");
        }
    }
}
