package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sakis on 12/9/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {

    private String artist;

    private String name;

    @JsonProperty("image")
    private List<AlbumImage> images;

    @JsonProperty("tags")
    private AlbumTag albumTags;

    public Album() {
        this.images = new ArrayList<AlbumImage>();
        this.artist = new String();
        this.name = new String();
        this.albumTags = new AlbumTag();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getArtist() { return artist; }

    public void setArtist(String artist) { this.artist = artist; }

    public List<AlbumImage> getImages() { return images; }

    public void setImages(List<AlbumImage> images) { this.images = images; }

    public AlbumTag getAlbumTags() { return albumTags; }

    public void setAlbumTags(AlbumTag albumTags) { this.albumTags = albumTags; }
}
