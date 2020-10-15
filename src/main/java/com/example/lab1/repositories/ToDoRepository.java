package com.example.lab1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab1.entities.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
}
