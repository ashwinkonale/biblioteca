package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OptionToBrowseMoviesTest extends OptionTest{
    List<Movie>listOfMovies=new ArrayList<Movie>();
    Option browseMovieOption;

    @Before
    public void setUp() throws Exception {
        mockOutput=mock(PrintStream.class);
        listOfMovies.add(new Movie("movie1","director1","9"));
        listOfMovies.add(new Movie("movie2","director2","5"));
        listOfMovies.add(new Movie("movie3","director3","N/A"));
        browseMovieOption=new OptionToBrowseMovies(mockOutput,"Browse Movies",listOfMovies);
    }

    @Test
    public void testDisplay() throws Exception {
        assertEquals(browseMovieOption.getName(), "Browse Movies");
    }

    @Test
    public void testPrintMovies() throws Exception {
        browseMovieOption.performAction();
        verify(mockOutput).println("movie1/director1/9");
        verify(mockOutput).println("movie2/director2/5");
        verify(mockOutput).println("movie3/director3/N/A");
    }

}
