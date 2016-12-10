package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookVolumeInfo {

    private String title;

    private List<String> authors;

    private List<String> categories;

    private String description;

    private Integer pageCount;

    @JsonProperty("imageLinks")
    private BookThumbnail thumbnail;

    public BookVolumeInfo() {
        title = "";
        authors = new ArrayList<String>();
        categories = new ArrayList<String>();
        description = "";
        pageCount = -1;
        thumbnail = new BookThumbnail();
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public List<String> getAuthors() { return authors; }

    public void setAuthors(List<String> authors) { this.authors = authors; }

    public List<String> getCategories() { return categories; }

    public void setCategories(List<String> categories) { this.categories = categories; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Integer getPageCount() { return pageCount; }

    public void setPageCount(Integer pageCount) { this.pageCount = pageCount; }

    public BookThumbnail getThumbnail() { return thumbnail; }

    public void setThumbnail(BookThumbnail thumbnail) { this.thumbnail = thumbnail; }
}
