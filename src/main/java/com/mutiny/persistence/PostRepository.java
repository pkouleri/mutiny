package com.mutiny.persistence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import com.mutiny.events.Event;
import com.mutiny.model.Post;

public class PostRepository extends AbstractRepository {

    public Post save(Post post) {
        // todo save post
        doClientEvent(new Event(post));
        return post;
    }

    public Post findOne(long id) {
        throw new NotImplementedException();
    }

    public List<Post> findAll() {
        throw new NotImplementedException();
    }

}
