package com.mutiny.dto;

import com.mutiny.model.Account;
import com.mutiny.model.Category;

public abstract class AbstractPostDto {

	// common properties
	public Integer id;

	public Account account;

	public Category category;

	public String description;

	public AbstractPostDto() {
	}

	public AbstractPostDto(Integer id, Account account, Category category) {
		this.id = id;
		this.account = account;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
