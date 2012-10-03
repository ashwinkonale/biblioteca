package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OptionToBrowseBooksTest extends OptionTest{
    Option browseBookOption;
    List<Book> listOfBooks=new ArrayList<Book>();
    @Before
    public void setUp() throws Exception {
        listOfBooks.add(new Book(1,"book1"));
        listOfBooks.add(new Book(2,"book2"));
        mockOutput=mock(PrintStream.class);
        browseBookOption=new OptionToBrowseBooks(mockOutput,"Browse Books",listOfBooks);
    }

    @Test
    public void testDisplayNameOfThisClass(){
        assertEquals(browseBookOption.getName(), "Browse Books");
    }
    @Test
    public void testPrintBooks(){
        browseBookOption.performAction();
        verify(mockOutput).println("1 : book1");
        verify(mockOutput).println("2 : book2");
    }

}
