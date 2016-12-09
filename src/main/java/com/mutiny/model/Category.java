package com.mutiny.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "CATEGORY", schema = "MUTINY")
public class Category {

	private Integer id;

	private String name;

	public Category() {
	}

	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Category(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
