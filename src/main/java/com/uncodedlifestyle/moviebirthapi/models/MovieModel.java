package com.uncodedlifestyle.moviebirthapi.models;

public class MovieModel {
    private String title;
    private String poster_path;
    private String overview;
    private String release_date;

    public MovieModel(String title, String poster_path, String overview, String release_date) {
        this.title = title;
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }
}
