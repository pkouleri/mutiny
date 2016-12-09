package com.mutiny.dao;

import org.springframework.data.repository.CrudRepository;

import com.mutiny.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
