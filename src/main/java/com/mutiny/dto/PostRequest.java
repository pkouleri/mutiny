package com.mutiny.dto;

public class PostRequest {

	public Integer id;

	public Integer accountId;

	public String category;

	private String albumName;

	private String artist;

	private String movieTitle;

	public String description;

	public String author;

	/* book */
	public String isbn;

	/* book, movie */
	public String title;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAlbumName() {
		return albumName;
	}

	public String getArtist() {
		return artist;
	}

	public String getMovieTitle() { return movieTitle; }

	public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }
}
