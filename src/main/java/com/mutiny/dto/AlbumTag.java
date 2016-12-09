package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sakis on 12/9/16.
 */
public class AlbumTag {

    @JsonProperty("tag")
    private List<Tag> tags;

    public AlbumTag() {
        this.tags = new ArrayList<Tag>();
    }


    public List<Tag> getTags() { return tags; }

    public void setTags(List<Tag> tags) { this.tags = tags; }
}
