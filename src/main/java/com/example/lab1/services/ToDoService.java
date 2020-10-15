package com.example.lab1.services;

import java.util.List;

import javax.transaction.Transactional;

import com.example.lab1.entities.ToDo;
import com.example.lab1.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ToDoService {

    @Autowired
    private ToDoRepository repo;

    public List<ToDo> findAll() {
        return repo.findAll();
    }

    public void save(ToDo product) {
        repo.save(product);
    }

    public ToDo find(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
