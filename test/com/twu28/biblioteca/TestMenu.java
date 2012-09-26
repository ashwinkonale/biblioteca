package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class TestMenu {
    private PrintStream mockOut;
    private Input mockInput;
    private Menu menu;
    private List<Book>books=new ArrayList<Book>();
    private List<Movie> movies=new ArrayList<Movie>();
    private List<MenuOption>menuOptions=new ArrayList<MenuOption>();


    @Before
    public void setUp() throws Exception {
        mockOut=mock(PrintStream.class);
        mockInput=mock(Input.class);

        books.add(new Book(1,"Immortals of meluha"));
        books.add(new Book(2,"Secret of nagas"));

        movies.add(new Movie("snatch","director1","7.5"));
        movies.add(new Movie("run","director2","8.9"));

        menuOptions.add(new MenuOptionToViewBooks(mockOut,books));
        menuOptions.add(new MenuOptionToViewMovies(mockOut,movies));
        menuOptions.add(new MenuOptionToReserveBook(mockInput,mockOut,books));
        menuOptions.add(new MenuOptionToLogin(mockInput,mockOut));

        menu=new Menu(mockOut,mockInput,menuOptions);

    }

    @Test
    public void shouldDisplayMenuOptions(){
        menu.displayMenuOption();
        verify(mockOut).println("1:View Books");
        verify(mockOut).println("3:View Movies");
        verify(mockOut).println("2:Reserve a book");
        verify(mockOut).println("4:Login");
    }
    @Test
    public void shouldDisplayListOfBooks(){
        menuOptions.get(0).performAction();
        verify(mockOut).println("1 : Immortals of meluha");
        verify(mockOut).println("2 : Secret of nagas");

    }
    @Test
    public void shouldPrintBooksWhenMenuOptionIsOne(){
        when(mockInput.nextInt()).thenReturn(1);
        menu.selectMenuOption();
        verify(mockOut).println("1 : Immortals of meluha");
        verify(mockOut).println("2 : Secret of nagas");
    }
    @Test
    public void shouldDisplayListOfMovies(){
        menuOptions.get(1).performAction();
        verify(mockOut).println("snatch/director1/7.5");
        verify(mockOut).println("run/director2/8.9");
    }
    @Test
    public void shouldPrintMoviesWhenMenuOptionIsTwo(){
        when(mockInput.nextInt()).thenReturn(3);
        menu.selectMenuOption();
        verify(mockOut).println("snatch/director1/7.5");
        verify(mockOut).println("run/director2/8.9");
    }
    @Test
    public void shouldBeAbleToReserveUnreservedBook(){
        MenuOption.isLoggedIn=true;
        when(mockInput.nextInt()).thenReturn(1);
        menuOptions.get(2).performAction();
        verify(mockOut).println("Enter the isbn of the book to be reserved");
        verify(mockOut).println("U hv reserved book -->1 : Immortals of meluha");
    }
    @Test
    public void shouldNotBeAbleToReserveAlreadyReservedBook(){
        MenuOption.isLoggedIn=true;
        when(mockInput.nextInt()).thenReturn(1,1);
        menuOptions.get(2).performAction();
        verify(mockOut).println("Enter the isbn of the book to be reserved");
        verify(mockOut).println("U hv reserved book -->1 : Immortals of meluha");
        menuOptions.get(2).performAction();
        verify(mockOut).println("1 : Immortals of meluha is not currently available");
    }
    @Test
    public void shouldPrintMessageIfBookIsNotAvailable(){
        MenuOption.isLoggedIn=true;
        when(mockInput.nextInt()).thenReturn(65);
        menuOptions.get(2).performAction();
        verify(mockOut).println("Sorry we don't have that book yet");
    }
    @Test
    public void shouldBeAbleToReserveBookWhenMenuOptionIsThree(){
        MenuOption.isLoggedIn=true;
        when(mockInput.nextInt()).thenReturn(2,1);
        menu.selectMenuOption();
        verify(mockOut).println("Enter the isbn of the book to be reserved");
        verify(mockOut).println("U hv reserved book -->1 : Immortals of meluha");
    }
    @Test
    public void shouldNotBeAbleToReserveBookWithoutLoggingIn(){
        MenuOption.isLoggedIn=false;
        when(mockInput.nextInt()).thenReturn(2);
        menuOptions.get(2).performAction();
        verify(mockOut).println("U need to login");
    }
    @Test
    public void testLogin(){
        MenuOption.isLoggedIn=false;
        when(mockInput.next()).thenReturn("ashwin","pass1");
        menuOptions.get(3).performAction();
        verify(mockOut).println("Enter Username");
        verify(mockOut).println("Enter Password");
        verify(mockOut).println("Login successful");
    }
    @Test
    public void shouldBeAbleToLoginWhenMenuOptionIsFour(){
        when(mockInput.nextInt()).thenReturn(4);
        when(mockInput.next()).thenReturn("ashwin","pass1");
        menu.selectMenuOption();
        verify(mockOut).println("Enter Username");
        verify(mockOut).println("Enter Password");
        verify(mockOut).println("Login successful");
    }
    @Test
    public void testUnsuccessfulLogin(){
        MenuOption.isLoggedIn=false;
        when(mockInput.next()).thenReturn("jasf","isfs");
        menuOptions.get(3).performAction();
        verify(mockOut).println("Enter Username");
        verify(mockOut).println("Enter Password");
        verify(mockOut).println("Incorrect Username or password");
    }
    @Test
    public void shouldNotBeAbleToLoginIfAlreadyLoggedIn(){
        MenuOption.isLoggedIn=false;
        when(mockInput.nextInt()).thenReturn(4,4);
        when(mockInput.next()).thenReturn("ashwin","pass1");

        menu.selectMenuOption();

        verify(mockOut).println("Enter Username");
        verify(mockOut).println("Enter Password");
        verify(mockOut).println("Login successful");

        menu.selectMenuOption();

        verify(mockOut).println("You are already logged in");
    }
}
