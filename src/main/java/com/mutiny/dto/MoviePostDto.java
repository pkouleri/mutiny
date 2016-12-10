package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviePostDto extends AbstractPostDto {

    @JsonProperty("results")
    private List<Movie> movies;

    private List<String> translatedGenres;

    public MoviePostDto() {
        movies = new ArrayList<Movie>();
        translatedGenres = new ArrayList<String>();
    }

    public List<Movie> getMovies() { return movies; }

    public void setMovies(List<Movie> results) { this.movies = results; }

    public List<String> getTranslatedGenres() { return translatedGenres; }

    public void setTranslatedGenres(List<String> translatedGenres) { this.translatedGenres = translatedGenres; }

}
