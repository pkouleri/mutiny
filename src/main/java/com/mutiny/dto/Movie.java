package com.mutiny.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @JsonProperty("poster_path")
    private String posterPath;

    private String overview;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("genre_ids")
    private List<Integer> genres;

    @JsonProperty("original_title")
    private String title;

    public Movie() {
        posterPath = "";
        overview = "";
        releaseDate = "";
        genres = new ArrayList<Integer>();
        title = "";
    }

    public String getPosterPath() { return posterPath; }

    public void setPosterPath(String posterPath) { this.posterPath = posterPath; }

    public String getOverview() { return overview; }

    public void setOverview(String overview) { this.overview = overview; }

    public String getReleaseDate() { return releaseDate; }

    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public List<Integer> getGenres() { return genres; }

    public void setGenres(List<Integer> genres) { this.genres = genres; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

}
