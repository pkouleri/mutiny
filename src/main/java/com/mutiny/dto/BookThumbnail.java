package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookThumbnail {

    @JsonProperty("thumbnail")
    private String name;

    public BookThumbnail() {
        name = "";
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
