package com.mutiny.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mutiny.dao.PostRepository;
import com.mutiny.dto.PostDto;
import com.mutiny.events.Event;
import com.mutiny.model.Post;

@Component
public class PostService extends AbstractService {

	PostRepository postRepository;

	public PostDto createPost(PostDto postDto) {
		// todo code to get info from movies, cinema, books APIs here

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
