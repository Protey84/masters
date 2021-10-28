package com.example.protey.service;

import com.example.protey.entity.Master;
import com.example.protey.repo.MasterRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MasterService {
    private MasterRepo repository;

    public MasterService(MasterRepo repository) {
        this.repository = repository;
    }

    public Master save(String master){
        return repository.save(new Master(master));
    }

    public List<Master> getMasters(){
        List<Master> list=new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}
