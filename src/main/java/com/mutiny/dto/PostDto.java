package com.mutiny.dto;

import com.mutiny.model.Account;
import com.mutiny.model.Category;
import com.mutiny.model.Post;

public class PostDto {

	public Integer id;

	public Account account;

	public Category category;

	/* common */
	public String imageUrl;

	public String description;

	public String author;

	/* music */
	public String albumName;

	/* book */
	public String isbn;

	/* book, movie */
	public String title;

	public PostDto() {
	}

	public PostDto(Integer id, Account account, Category category) {
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Post toEntity() {
		return new Post(account, category, getContent());
	}

	public PostDto fromEntity(Post post) {
		return new PostDto(post.getId(), post.getAccount(), post.getCategory());
	}

	private String getContent() {
		return "test";
	}


}
