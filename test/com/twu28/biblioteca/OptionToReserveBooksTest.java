package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OptionToReserveBooksTest extends OptionTest{
    List<Book> listOfBooks=new ArrayList<Book>();
    Option reserveBookOption;

    @Before
    public void setUp() throws Exception {
        listOfBooks.add(new Book(1,"book1"));
        listOfBooks.add(new Book(2,"book2"));
        listOfBooks.add(new Book(3,"book3"));
        listOfBooks.add(new Book(4,"book4"));
        mockInput=mock(Input.class);
        mockOutput=mock(PrintStream.class);
        Option.isLoggedIn=true;
        reserveBookOption=new OptionToReserveBooks(mockInput,mockOutput,"Reserve a Book",listOfBooks);
    }
    @Test
    public void testClassNameOfReserveBook(){
        assertEquals(reserveBookOption.getName(), "Reserve a Book");
    }

    @Test
    public void shouldBeAbleToReserveUnreservedBook(){
        when(mockInput.nextInt()).thenReturn(2);
        reserveBookOption.performAction();
        verify(mockOutput).println("Enter the isbn of the book to be reserved");
        verify(mockOutput).println("2 : book2 is reserved");
    }
    @Test
    public void shouldNotBeAbleToReserveAlreadyReservedBook(){
        when(mockInput.nextInt()).thenReturn(2,2);
        reserveBookOption.performAction();
        verify(mockOutput).println("Enter the isbn of the book to be reserved");
        verify(mockOutput).println("2 : book2 is reserved");
        reserveBookOption.performAction();
        verify(mockOutput).println("sorry 2 : book2 is not currently available");

    }
    @Test
    public void shouldPrintErrorMsgIfBookIsNotAvailable(){
        when(mockInput.nextInt()).thenReturn(23);
        reserveBookOption.performAction();
        verify(mockOutput).println("Enter the isbn of the book to be reserved");
        verify(mockOutput).println("Requested book is not available");
    }
    @Test
    public void shouldNotBeAbleToReserveWithoutLoggingIn(){
        Option.isLoggedIn=false;
        reserveBookOption.performAction();
        verify(mockOutput).println("you need to login");
    }
}
