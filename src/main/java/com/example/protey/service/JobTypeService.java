package com.example.protey.service;

import com.example.protey.entity.JobType;
import com.example.protey.repo.JobTypeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobTypeService {
    private JobTypeRepo repository;

    public JobTypeService(JobTypeRepo repository) {
        this.repository = repository;
    }

    public List<JobType> getAll(){
        List<JobType> list=new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public JobType save(String newJobType){
        return repository.save(new JobType(newJobType));
    }

}
