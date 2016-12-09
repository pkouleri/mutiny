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

import com.mutiny.dto.PostDto;
import com.mutiny.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PostDto createPost(@RequestBody PostDto post) {
        return postService.createPost(post);
    }

    @RequestMapping(method = { RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PostDto updatePost(@RequestBody PostDto post) {
        return postService.updatePost(post);
    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PostDto getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PostDto deletePost(@PathVariable Integer id) {
        return postService.getPost(id);
    }

    @RequestMapping(path = "/list", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PostDto> getPosts(@RequestParam List<String> categories) {
        return postService.getPosts(categories);
    }

}