package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sakis on 12/9/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumImage {

    @JsonProperty("#text")
    private String imageUrl;

    private String size;

    public AlbumImage() {
        this.imageUrl = new String();
        this.size = new String();
    }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}