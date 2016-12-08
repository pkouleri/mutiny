package com.mutiny.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mutiny.dao.PostRepository;
import com.mutiny.model.Post;

@Component
public class PostService {

	PostRepository postRepository;

	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	public Post getPost(long id) {
		return postRepository.findOne(id);
	}

	public Post updatePost(Post post) {
		return postRepository.save(post);
	}

	public List<Post> getPosts(List<String> categories) {
		return postRepository.findAll();
	}
}
