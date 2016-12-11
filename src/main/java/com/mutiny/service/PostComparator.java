package com.mutiny.service;

import com.mutiny.model.Post;

import java.util.Comparator;

public class PostComparator implements Comparator<Post> {

    public PostComparator() {
    }

    @Override
    public int compare(Post post1, Post post2) {
        if (post1.getId() == post2.getId()) {
            return 0;
        } else if (post1.getId() >= post2.getId()) {
            return 1;
        } else  {
            return -1;
        }
    }
}
