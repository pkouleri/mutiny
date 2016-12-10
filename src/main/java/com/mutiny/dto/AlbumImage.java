package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumImage {

    private String imageUrl;

    private String size;

    public AlbumImage() {
    }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("#text")
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    @JsonSetter("imageUrl")
    private void setAlternateImageUrl(String imageUrl) {
        if (this.imageUrl == null) {
            setImageUrl(imageUrl);
        }
    }
}
