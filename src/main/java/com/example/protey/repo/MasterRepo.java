package com.example.protey.repo;

import com.example.protey.entity.Master;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepo extends CrudRepository<Master, Integer> {
}
