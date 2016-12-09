package com.mutiny.dao;

import org.springframework.data.repository.CrudRepository;

import com.mutiny.model.Account;

public interface UserRepository extends CrudRepository<Account, Integer> {

}
