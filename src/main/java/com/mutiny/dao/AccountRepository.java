package com.mutiny.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mutiny.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	@Query("select a from Account a where a.principal = :principal")
	public Account findByPrincipal(@Param("principal") String principal);
}
