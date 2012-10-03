package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class OptionToLoginTest extends OptionTest {
    List<User>users=new ArrayList<User>();
    Option optionToLogin;

    @Before
    public void setUp() throws Exception {
        mockOutput=mock(PrintStream.class);
        mockInput=mock(Input.class);
        users.add(new User("user1","pass1"));
        users.add(new User("user2","pass2"));
        users.add(new User("user3","pass3"));
        optionToLogin=new OptionToLogin(mockOutput,"Login",mockInput, users);
        Option.isLoggedIn=false;
    }

    @Test
    public void shouldBeAbleToLoginWithCorrectUsernameAndPassword(){
        users.add(new User("ashwin","pass1"));
        optionToLogin=new OptionToLogin(mockOutput,"Login",mockInput,users);
        when(mockInput.next()).thenReturn("ashwin","pass1");
        optionToLogin.performAction();
        verify(mockOutput).println("Enter Username");
        verify(mockOutput).println("Enter Password");
        verify(mockOutput).println("Login successful");

    }
    @Test
    public void shouldBeAbleToLoginWithAnotherUserNameAndPassword(){
        when(mockInput.next()).thenReturn("user1","pass1");
        optionToLogin.performAction();
        verify(mockOutput).println("Enter Username");
        verify(mockOutput).println("Enter Password");
        verify(mockOutput).println("Login successful");

    }
    @Test
    public void shouldNotBeAbleToLoginWithIncorrectUsernameOrPassword(){
        when(mockInput.next()).thenReturn("blah","blah");
        optionToLogin.performAction();
        verify(mockOutput).println("Enter Username");
        verify(mockOutput).println("Enter Password");
        verify(mockOutput).println("Incorrect username or password");
    }
    @Test
    public void shouldNotBeAbleToLoginIfAlreadyLoggedIn(){
        when(mockInput.next()).thenReturn("user1","pass1");
        optionToLogin.performAction();
        verify(mockOutput).println("Enter Username");
        verify(mockOutput).println("Enter Password");
        verify(mockOutput).println("Login successful");
        optionToLogin.performAction();
        verify(mockOutput).println("You are already logged in");
    }
}
