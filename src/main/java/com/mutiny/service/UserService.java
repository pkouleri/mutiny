package com.mutiny.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mutiny.dao.UserRepository;
import com.mutiny.model.User;

/**
 * User management methods (CRUD, etc)
 */
public class UserService extends AbstractService {

	@Autowired
	UserRepository userRepository;

	public User getUser(Integer id) {
		return userRepository.findOne(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

}
