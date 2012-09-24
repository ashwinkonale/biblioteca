package com.twu28.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestInterface {
    List<Book> books=new ArrayList<Book>();
    private PrintStream mockOut;
    private UserInterface userInterface;
    private Input mockInput;

    @Before
    public void setUp() throws Exception {

        mockOut=mock(PrintStream.class);
        mockInput=mock(Input.class);
        userInterface=new UserInterface(mockOut,mockInput,books);

        books.add(new Book(1, "The Alchemist"));
        books.add(new Book(33,"The monk who sold his ferrari"));

    }

    @Test
    public void shouldPrintMenuOptions(){
        userInterface.printMenuOptions();
        verify(mockOut).println("Welcome to library");
        verify(mockOut).println("View books");
        verify(mockOut).println("Reserve a book");
        verify(mockOut).println("View movie list");
        verify(mockOut).println("Login");
        verify(mockOut).println("Exit");
    }
    @Test
    public void shouldPrintBooksInLibrary(){
        userInterface.printBooks();
        verify(mockOut).println("1 : The Alchemist");
        verify(mockOut).println("33 : The monk who sold his ferrari");
    }
    @Test
    public void shouldBeAbleToReserveUnreservedBook(){
        when(mockInput.nextInt()).thenReturn(1,33);
        userInterface.reserveBook();
        verify(mockOut).println("Enter the isbn of the book to be reserved");
        verify(mockOut).println("U hv reserved book -->1 : The Alchemist");
        userInterface.reserveBook();
        verify(mockOut).println("U hv reserved book -->33 : The monk who sold his ferrari");
    }
    @Test
    public void shouldShowErrorMessageIfTheBookIsNotAvailable() throws Exception{
        when(mockInput.nextInt()).thenReturn(4);
        userInterface.reserveBook();
        verify(mockOut).println("Sorry we don't have that book yet");
    }
    @Test
    public void shouldNotBeAbleToReserveAlreadyReservedBooks(){
        when(mockInput.nextInt()).thenReturn(1);
        userInterface.reserveBook();
        verify(mockOut).println("Enter the isbn of the book to be reserved");
        verify(mockOut).println("U hv reserved book -->1 : The Alchemist");
        when(mockInput.nextInt()).thenReturn(1);
        userInterface.reserveBook();
        verify(mockOut).println("1 : The Alchemist is not currently available");
    }




}
