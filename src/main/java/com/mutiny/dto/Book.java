package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    @JsonProperty("volumeInfo")
    private BookVolumeInfo info;

    public Book() {
        info = new BookVolumeInfo();
    }

    public BookVolumeInfo getInfo() { return info; }

    public void setInfo(BookVolumeInfo info) { this.info = info; }
}
