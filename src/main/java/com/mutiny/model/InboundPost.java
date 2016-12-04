package com.mutiny.model;

import com.mutiny.dto.Post;

public class InboundPost {

    private String content;

    public InboundPost() {
    }

    public InboundPost(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post toEntity() {
        return null;
    }
}
