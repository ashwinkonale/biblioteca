package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class MenuOptionToViewMovies extends MenuOption{
    private List<Movie> movies;
    public MenuOptionToViewMovies(PrintStream output, List<Movie> movies){
        this.output=output;
        this.movies=movies;
        menuOptionName="View Movies";
        indexNumber=3;
    }
    public void performAction() {
        for(Movie movie:movies){
            output.println(movie.display());
        }
    }
}
