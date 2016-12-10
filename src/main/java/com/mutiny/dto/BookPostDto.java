package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookPostDto extends AbstractPostDto {

    @JsonProperty("items")
    private List<Book> books;

    public BookPostDto() {
        books = new ArrayList<Book>();
    }

    public List<Book> getBooks() { return books; }

    public void setBooks(List<Book> books) { this.books = books; }
}
