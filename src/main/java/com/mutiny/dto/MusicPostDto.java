package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mutiny.support.JsonHelper;

public class MusicPostDto extends AbstractPostDto {

	private Album album;

	@JsonProperty("artist")
	private String artist;

	@JsonProperty("name")
	public String albumName;

	@JsonProperty("#text")
	public String imageUrl;

	public MusicPostDto() {
		this.album = new Album();
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override public String getContent() {
		return JsonHelper.toJson(this);
	}
}
