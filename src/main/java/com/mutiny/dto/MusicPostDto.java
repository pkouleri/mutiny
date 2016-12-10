package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MusicPostDto extends AbstractPostDto {

	private Album album;


	public MusicPostDto() {
		this.album = new Album();
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}
