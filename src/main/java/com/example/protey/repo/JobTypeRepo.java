package com.example.protey.repo;

import com.example.protey.entity.JobType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepo extends CrudRepository<JobType, Integer> {
}
