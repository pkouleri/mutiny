package com.mutiny.web.controller;

import java.util.List;

import com.mutiny.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutiny.dto.AbstractPostDto;
import com.mutiny.dto.PostRequest;
import com.mutiny.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<AbstractPostDto> createPost(@RequestBody PostRequest post) {
        AbstractPostDto postDto = postService.createPost(post);
        if (postDto != null) {
            return new ResponseEntity<AbstractPostDto>(postDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<AbstractPostDto>(postDto, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = { RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AbstractPostDto updatePost(@RequestBody AbstractPostDto post) {
        return postService.updatePost(post);
    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public AbstractPostDto getPost(@PathVariable Integer id) {
        return postService.getPost(id);
    }

    @RequestMapping(path = "/{id}", method = { RequestMethod.DELETE }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Post> deletePost(@PathVariable Integer id) {
        Post post = postService.deletePost(id);
        if (post == null) {
            return new ResponseEntity<Post>(post, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Post>(post, HttpStatus.OK);
        }
    }

    @RequestMapping(path = "/list", method = { RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<AbstractPostDto> getPosts(@RequestParam List<String> categories) {
        return postService.getPosts(categories);
    }

}
