package com.example.protey.repo;

import com.example.protey.entity.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends CrudRepository<Job, Integer> {
}
