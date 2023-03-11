package org.example.repo;

import org.example.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TaskRepo extends CrudRepository<Task, Integer> {
    List<Task> findByStatus(String status);
}
