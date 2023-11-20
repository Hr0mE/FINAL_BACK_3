package com.example.final_back_3.Repository;

import com.example.final_back_3.Model.userEntity;
import org.springframework.data.repository.CrudRepository;


public interface userRepository extends CrudRepository<userEntity, Integer> {
    boolean findById(boolean b);
}
