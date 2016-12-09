package com.mutiny.dao;

import org.springframework.data.repository.CrudRepository;

import com.mutiny.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
