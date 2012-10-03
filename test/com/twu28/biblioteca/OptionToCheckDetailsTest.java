package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OptionToCheckDetailsTest extends OptionTest{
    private Option optionToCheckDetails;

    @Before
    public void setUp() throws Exception {
        mockOutput=mock(PrintStream.class);
        optionToCheckDetails=new OptionToCheckDetails(mockOutput,"Check details");
    }

    @Test
    public void shouldDisplayDetailsIfLoggedIn(){
        Option.isLoggedIn=true;
        Option.loggedInUser=new User("Ashwin","password");
        optionToCheckDetails.performAction();
        verify(mockOutput).println("Your username is Ashwin");
    }
    @Test
    public void shouldDisplayMessageIfNotLoggedIn(){
        Option.isLoggedIn=false;
        optionToCheckDetails.performAction();
        verify(mockOutput).println("Please talk to the Librarian");
    }
}
