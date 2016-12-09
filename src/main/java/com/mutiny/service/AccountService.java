package com.mutiny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mutiny.dao.AccountRepository;
import com.mutiny.dto.AccountDto;
import com.mutiny.model.Account;

/**
 * User management methods (CRUD, etc)
 */
@Component
public class AccountService extends AbstractService {

	@Autowired
	AccountRepository accountRepository;

	public AccountDto getAccount(Integer id) {
		Account account = accountRepository.findOne(id);
		return new AccountDto().fromEntity(account);
	}

	public AccountDto createAccount(AccountDto accountDto) {
		Account account = accountRepository.save(accountDto.toEntity(accountDto));
		return new AccountDto().fromEntity(account);
	}

}
