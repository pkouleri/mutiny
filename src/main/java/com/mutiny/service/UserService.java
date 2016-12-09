package com.mutiny.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mutiny.dao.UserRepository;
import com.mutiny.model.Account;

/**
 * User management methods (CRUD, etc)
 */
public class UserService extends AbstractService {

	@Autowired
	UserRepository userRepository;

	public Account getUser(Integer id) {
		return userRepository.findOne(id);
	}

	public Account createUser(Account account) {
		return userRepository.save(account);
	}

}
