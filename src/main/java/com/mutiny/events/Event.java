package com.mutiny.events;

import com.mutiny.dto.AbstractPostDto;
import com.mutiny.model.Post;
import com.mutiny.support.JsonHelper;

public class Event {

    String content;

    public Event(Post post) {
        this.content = JsonHelper.toJson(post);
    }

    public Event(String content) {
        this.content = content;
    }

    public Event(AbstractPostDto postDto) {
        this.content = JsonHelper.toJson(postDto);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
