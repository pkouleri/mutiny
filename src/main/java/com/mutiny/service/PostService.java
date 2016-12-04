package com.mutiny.service;

import com.mutiny.dto.PostDto;
import com.mutiny.model.Post;
import com.mutiny.persistence.PostRepository;
import org.springframework.stereotype.Component;

@Component
public class PostService {

    PostRepository postRepository;

    public void createPost(PostDto post) {

        postRepository.save(post.toEntity());
    }
}
