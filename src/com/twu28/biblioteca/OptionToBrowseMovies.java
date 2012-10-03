package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class OptionToBrowseMovies extends Option {
    List<Movie>listOfMovies;
    public OptionToBrowseMovies(PrintStream output, String name, List<Movie> listOfMovies) {
        super(output, name);
        this.listOfMovies=listOfMovies;
    }
    public void performAction(){
        for(Movie movie:listOfMovies){
            output.println(movie.display());
        }
    }
}
