package com.mutiny.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mutiny.dao.AccountRepository;
import com.mutiny.dao.CategoryRepository;
import com.mutiny.dao.PostRepository;
import com.mutiny.dto.AbstractPostDto;
import com.mutiny.dto.BookPostDto;
import com.mutiny.dto.MoviePostDto;
import com.mutiny.dto.MusicPostDto;
import com.mutiny.dto.PostRequest;
import com.mutiny.events.Event;
import com.mutiny.model.Account;
import com.mutiny.model.Category;
import com.mutiny.model.Post;
import com.mutiny.support.JsonHelper;

@Component
public class PostService extends AbstractService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ApiClient apiClient;

	public AbstractPostDto createPost(PostRequest postRequest) {
		AbstractPostDto postDto = null;

		// 1. get info from external API
		switch  (postRequest.getCategory().toLowerCase()) {
			case "music":
				postDto = apiClient.getMusicContent(postRequest.getAlbumName(), postRequest.getArtist());
				break;
			case "movie":
				postDto = apiClient.getMovieContent(postRequest.getMovieTitle());
				break;
		}

		// 2. save to DB
		if (postDto != null) {
			Account account = accountRepository.findOne(postRequest.getAccountId());
			Category category = categoryRepository.findByName(postRequest.getCategory());
			Post post = postRepository.save(new Post(account, category, JsonHelper.toJson(postDto)));
			if (post != null) {
				doClientEvent(new Event(post));
			}
		}

		return postDto;
	}

	public AbstractPostDto getPost(Integer id) {
		AbstractPostDto dto = null;

		Post post = postRepository.findOne(id);
		switch (post.getCategory().getName()) {
		case "music":
			dto = JsonHelper.fromJson(post.getContent(), new TypeReference<MusicPostDto>() {
			});
			break;
		case "movie":
			dto = JsonHelper.fromJson(post.getContent(), new TypeReference<MoviePostDto>() {
			});
			break;
		case "book":
			dto = JsonHelper.fromJson(post.getContent(), new TypeReference<BookPostDto>() {
			});
			break;
		}

		if (dto != null) {
			dto.setId(post.getId());
			dto.setAccount(post.getAccount());
			dto.setCategory(post.getCategory());
		}

		return dto;
	}

	public AbstractPostDto updatePost(AbstractPostDto post) {
		return null;
	}

	public List<AbstractPostDto> getPosts(List<String> categories) {
		List<AbstractPostDto> abstractPostDtos = new ArrayList<>();
		//		for (Post post : postRepository.findByCategory(categories)) {
		//			abstractPostDtos.add(new AbstractPostDto().fromEntity(post));
		//		}
		return abstractPostDtos;
	}
}
