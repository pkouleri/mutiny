package com.mutiny.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.mutiny.dao.AccountRepository;
import com.mutiny.dao.CategoryRepository;
import com.mutiny.dao.PostRepository;
import com.mutiny.dto.Album;
import com.mutiny.dto.AlbumImage;
import com.mutiny.dto.MusicResponse;
import com.mutiny.dto.PostDto;
import com.mutiny.events.Event;
import com.mutiny.model.Category;
import com.mutiny.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class PostService extends AbstractService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	AccountRepository accountRepository;

	public PostDto createPost(PostDto postDto) {

		if (categoryRepository.findOne(postDto.category.getId()).getName().equals("Music")) {
			postDto.account = accountRepository.findOne(postDto.account.getId());
			postDto.category = categoryRepository.findByName(postDto.category.getName());
		}

		Post post = postRepository.save(postDto.toEntity());
		if (post != null) {
			doClientEvent(new Event(post));
		}
		return new PostDto().fromEntity(post);
	}

	public PostDto getPost(Integer id) {
		return new PostDto().fromEntity(postRepository.findOne(id));
	}

	public PostDto updatePost(PostDto post) {
		return null;
	}

	public List<PostDto> getPosts(List<String> categories) {
		List<PostDto> postDtos = new ArrayList<>();
		for (Post post : postRepository.findByCategory(categories)) {
			postDtos.add(new PostDto().fromEntity(post));
		}
		return postDtos;
	}
}
