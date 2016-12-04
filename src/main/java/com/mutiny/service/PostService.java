package com.mutiny.service;

import com.mutiny.model.InboundPost;
import com.mutiny.persistence.PostRepository;
import org.springframework.stereotype.Component;

@Component
public class PostService {

    PostRepository postRepository;

    public void createPost(InboundPost post) {
        postRepository.save(post);
    }
}
