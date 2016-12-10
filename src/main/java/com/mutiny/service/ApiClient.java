package com.mutiny.service;

import java.util.*;

import com.mutiny.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiClient {

	RestTemplate restTemplate = new RestTemplate();

	public MusicPostDto getMusicContent(String album, String artist) {
		MusicPostDto response = new MusicPostDto();
		String musicUrl = "http://ws.audioscrobbler.com/2.0/?method={method}&api_key={api_key}&artist={artist}&album={album}&format={format}";
		Map<String, String> parameters = new HashMap<>(5);
		parameters.put("method", "album.getinfo");
		parameters.put("api_key", "4518374e76d4e50422d00d9af42b32cd");
		parameters.put("artist", artist);
		parameters.put("album", album);
		parameters.put("format", "json");
		try {
			response = restTemplate.getForObject(musicUrl, MusicPostDto.class, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (response.getAlbum().getName().equals("") && response.getAlbum().getArtist().equals("")) {
			return null;
		} else {
			for (Iterator<AlbumImage> iterator = response.getAlbum().getImages().iterator(); iterator.hasNext(); ) {
				AlbumImage image = iterator.next();
				if (!image.getSize().equals("extralarge")) {
					iterator.remove();
				}
			}
			return response;
		}
	}

	public MoviePostDto getMovieContent(String name) {
		MoviePostDto response = new MoviePostDto();
		MovieGenreList genresList = new MovieGenreList();
		String movieUrl = "https://api.themoviedb.org/3/search/movie?api_key={api_key}&query={name}";
		String genresUrl = "https://api.themoviedb.org/3/genre/movie/list?api_key={api_key}&language={language}";
		Map<String, String> parameters = new HashMap<>(3);
		parameters.put("api_key", "a9a3ae009ae73c8ad330b35f9ab78899");
		parameters.put("name", name);
		parameters.put("language", "en-US");
		try {
			response = restTemplate.getForObject(movieUrl, MoviePostDto.class, parameters);
			genresList = restTemplate.getForObject(genresUrl, MovieGenreList.class, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (response.getMovies().size() == 0) {
			return null;
		} else {
			Movie firstMovie = response.getMovies().get(0);
			response.getMovies().clear();
			response.getMovies().add(firstMovie);

			String postPath = response.getMovies().get(0).getPosterPath();
			response.getMovies().get(0).setPosterPath("https://image.tmdb.org/t/p/w342" + postPath);

			for (Integer genreId : response.getMovies().get(0).getGenres()) {
				for ( MovieGenre gerne : genresList.getGenresList() ) {
					if (gerne.getId().equals(genreId)) {
						response.getTranslatedGenres().add(gerne.getName());
					}
				}
			}
			return response;
		}
	}

	public BookPostDto getBookContent(String author, String title) {
		BookPostDto response = new BookPostDto();
		String bookUrl = "https://www.googleapis.com/books/v1/volumes?q=intitle:\"{title}\"+inauthor:\"{author}\"\"";
		Map<String, String> parameters = new HashMap<>(2);
		parameters.put("title", title);
		parameters.put("author", author);
		try {
			response = restTemplate.getForObject(bookUrl, BookPostDto.class, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (response.getBooks().size() == 0) {
			return null;
		} else {
			Book book = new Book();
			for (Book b : response.getBooks()) {
				if (!b.getInfo().getThumbnail().getName().equals("")) {
					book = b;
					break;
				} else {
					book = null;
				}
			}
			if (book == null) {
				book = response.getBooks().get(0);
			}
			response.getBooks().clear();
			response.getBooks().add(book);
			response.getBooks().get(0).getInfo().setDescription(response.getBooks().get(0).getInfo().getDescription().substring(0, 400));
			return response;
		}
	}

}
