package com.example.protey.repo;

import com.example.protey.entity.Master;
import com.example.protey.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepo extends CrudRepository<Task, Integer> {
    List<Task> findAllByDate(LocalDate date);
    List<Task> findAllByDateBetween(LocalDate before, LocalDate after);
    List<Task> findAllByDateBetweenAndMaster(LocalDate before, LocalDate after, Master master);
}
