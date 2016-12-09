package com.mutiny.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutiny.dto.AlbumImage;
import com.mutiny.dto.BookPostDto;
import com.mutiny.dto.MusicPostDto;

@Component
public class ApiClient {

	RestTemplate restTemplate = new RestTemplate();

	public MusicPostDto getMusicContent(String album, String artist) {
		MusicPostDto response = new MusicPostDto();

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		String musicUrl = "http://ws.audioscrobbler.com/2.0/?method={method}&api_key={api_key}&artist={artist}&album={album}&format={format}";
		Map<String, String> parameters = new HashMap<>(5);
		parameters.put("method", "album.getinfo");
		parameters.put("api_key", "4518374e76d4e50422d00d9af42b32cd");
		parameters.put("artist", artist);
		parameters.put("album", album);
		parameters.put("format", "json");

		try {
			response = restTemplate.getForObject(musicUrl, MusicPostDto.class, parameters);
			for (Iterator<AlbumImage> iterator = response.getAlbum().getImages().iterator(); iterator.hasNext(); ) {
				AlbumImage image = iterator.next();
				if (!image.getSize().equals("extralarge")) {
					iterator.remove();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	public BookPostDto getBookContent(String author, String title) {
		return null;
	}

}
