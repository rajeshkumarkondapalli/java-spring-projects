package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.model.*;

public interface UserRepository extends CrudRepository<User, Integer> {

}
