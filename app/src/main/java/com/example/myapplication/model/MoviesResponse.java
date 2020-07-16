package com.example.myapplication.model;

import java.util.List;

public class MoviesResponse {
private int page;
private int total_results;
private int total_pages;
private List<MoviesResponseResults> results;

    public int getPage() {
        return page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<MoviesResponseResults> getResults() {
        return results;
    }

    public MoviesResponse(int page, int total_results, int total_pages, List<MoviesResponseResults> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public MoviesResponse() {
    }
}
