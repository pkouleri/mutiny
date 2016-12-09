package com.mutiny.dto;

import com.mutiny.model.Account;

public class AccountDto {

	private Integer id;

	private String username;

	private String type;

	private String email;

	public AccountDto() {
	}

	public AccountDto(String username, String type, String email) {
		this.username = username;
		this.type = type;
		this.email = email;
	}

	public AccountDto(Integer id, String username, String type, String email) {
		this.id = id;
		this.username = username;
		this.type = type;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AccountDto fromEntity(Account account) {
		return new AccountDto(account.getId(), account.getUsername(), account.getType(), account.getEmail());
	}

	public Account toEntity(AccountDto accountDto) {
		return new Account(accountDto.getUsername(), accountDto.getType(), accountDto.getEmail());
	}
}
