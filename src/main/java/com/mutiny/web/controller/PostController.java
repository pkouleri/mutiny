package com.mutiny.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutiny.model.Post;
import com.mutiny.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @RequestMapping(method = { RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post getPost(@PathVariable long id) {
        return postService.getPost(id);
    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Post deletePost(@PathVariable long id) {
        return postService.getPost(id);
    }

    @RequestMapping(path = "/list", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Post> getPosts(@RequestParam List<String> categories) {
        return postService.getPosts(categories);
    }

}
