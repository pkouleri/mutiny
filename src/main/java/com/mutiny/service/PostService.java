package com.mutiny.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Iterables;
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
		switch (postRequest.getCategory().toLowerCase()) {
		case "music":
			postDto = apiClient.getMusicContent(postRequest.getAlbumName(), postRequest.getArtist());
			break;
		case "movies":
			postDto = apiClient.getMovieContent(postRequest.getTitle());
			break;
		case "books":
			postDto = apiClient.getBookContent(postRequest.getAuthor(), postRequest.getTitle());
			break;
		default:
			return null;

		}

		// 2. save to DB
		if (postDto != null) {
			postDto.setDescription(postRequest.getDescription());

			Account account = accountRepository.findOne(postRequest.getAccountId());
			Category category = categoryRepository.findByNameIgnoreCase(postRequest.getCategory());

			Post post = postRepository.save(new Post(account, category, JsonHelper.toJson(postDto)));
			if (post != null) {
				postDto.setId(post.getId());
				postDto.setAccount(account);
				postDto.setCategory(category);

				doClientEvent(new Event(postDto));
			}
		}

		return postDto;
	}

	public Post deletePost(Integer postId) {
		Post post = null;
		post = postRepository.findOne(postId);
		if (post != null) {
			postRepository.delete(post);
		}
		return post;
	}

	public AbstractPostDto getPost(Integer id) {
		Post post = postRepository.findOne(id);
		return getPostDto(post);
	}

	public AbstractPostDto updatePost(AbstractPostDto post) {
		return null;
	}

	public List<AbstractPostDto> getPosts(List<String> categories) {
		List<AbstractPostDto> dtos = new ArrayList<>();
		List<Post> posts = new ArrayList<>();
		if (!CollectionUtils.isEmpty(categories)) {
			posts = postRepository.findByCategory(categories);
		} else {
			Iterables.addAll(posts, postRepository.findAll());
		}

		for (Post post : posts) {
			dtos.add(getPostDto(post));
		}
		return dtos;
	}

	private AbstractPostDto getPostDto(Post post) {
		AbstractPostDto dto = null;
		switch (post.getCategory().getName()) {
		case "music":
			dto = JsonHelper.fromJson(post.getContent(), new TypeReference<MusicPostDto>() {
			});
			break;
		case "movies":
			dto = JsonHelper.fromJson(post.getContent(), new TypeReference<MoviePostDto>() {
			});
			break;
		case "books":
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
}
