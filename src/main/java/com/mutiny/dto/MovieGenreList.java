package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MovieGenreList {

    @JsonProperty("genres")
    private List<MovieGenre> genresList;

    public MovieGenreList() {
        genresList = new ArrayList<MovieGenre>();
    }

    public List<MovieGenre> getGenresList() { return genresList; }

    public void setGenresList(List<MovieGenre> genresList) { this.genresList = genresList; }

}
