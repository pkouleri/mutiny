package com.mutiny.dto;

import com.mutiny.model.Account;

public class AccountDto {

	private Integer id;

	private String username;

	private String type;

	private String email;
	
	private String principal;
	
	private Boolean isNewUser;

	public Boolean getIsNewUser() {
		return isNewUser;
	}

	public void setIsNewUser(Boolean isNewUser) {
		this.isNewUser = isNewUser;
	}

	public AccountDto() {
	}
	
	public AccountDto(String username, String type, String email) {
		this.username = username;
		this.type = type;
		this.email = email;
	}
	
	public AccountDto(Integer id, String username, String type, String email, String principal) {
		this.id = id;
		this.username = username;
		this.type = type;
		this.email = email;
		this.principal = principal;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
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
		return new AccountDto(account.getId(), account.getUsername(), account.getType(), account.getEmail(), account.getPrincipal());
	}

	public Account toEntity(AccountDto accountDto) {
		return new Account(accountDto.getUsername(), accountDto.getType(), accountDto.getEmail(), accountDto.getPrincipal());
	}
}
