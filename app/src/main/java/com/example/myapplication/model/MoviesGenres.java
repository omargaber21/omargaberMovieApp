package com.example.myapplication.model;

public class MoviesGenres {
    private int id;
    private int name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public MoviesGenres(int id, int name) {
        this.id = id;
        this.name = name;
    }
}
