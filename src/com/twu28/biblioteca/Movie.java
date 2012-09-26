package com.twu28.biblioteca;

public class Movie {
    private String movieName;
    private String director;
    private String rating;
    public Movie(String movieName,String director,String rating){
        this.movieName=movieName;
        this.director=director;
        this.rating=rating;
    }
    public String display(){
        return movieName+"/"+director+"/"+rating;
    }
}
