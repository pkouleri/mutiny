package com.mutiny.dto;

import com.mutiny.model.Account;
import com.mutiny.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutiny.model.Post;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PostDto {

	public Integer id;

	public Account account;

	public Category category;

	/* common */
	@JsonProperty("#text")
	public String imageUrl;

	public String description;

	public String author;

	/* music */
	@JsonProperty("artist")
	public String artist;
	@JsonProperty("name")
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

	public String getArtist() { return artist; }

	public void setArtist(String artist) { this.artist = artist; }

	public Post toEntity() {
		return new Post(account, category, getContent());
	}

	public PostDto fromEntity(Post post) {
		return new PostDto(post.getId(), post.getAccount(), post.getCategory());
	}

	public String getContent() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

		RestTemplate restTemplate = new RestTemplate();
		String musicUrl = "http://ws.audioscrobbler.com/2.0/?method={method}&api_key={api_key}&artist={artist}&album={album}&format={format}";
		Map<String, String> parameters = new HashMap<String, String>(5);
		parameters.put("method", "album.getinfo");
		parameters.put("api_key", "4518374e76d4e50422d00d9af42b32cd");
		parameters.put("artist", getArtist());
		parameters.put("album", getAlbumName());
		parameters.put("format", "json");

		MusicResponse response = new MusicResponse();
		try {
			response = restTemplate.getForObject(musicUrl, MusicResponse.class, parameters);
		}catch(Exception e){
			e.printStackTrace();
		}

		for (Iterator<AlbumImage> iterator = response.getAlbum().getImages().iterator(); iterator.hasNext();) {
			AlbumImage image = iterator.next();
			if (!image.getSize().equals("extralarge")) {
				iterator.remove();
			}
		}

		String jsonResponse = new String();
		try {
			jsonResponse = mapper.writeValueAsString(response.getAlbum());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonResponse;
	}


}
