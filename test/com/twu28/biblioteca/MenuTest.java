package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.*;

public class MenuTest {
    private PrintStream mockOutput;
    private Input mockInput;
    private Menu menu;
    private HashMap<String,Option>menuOption;
    @Before
    public void setUp() throws Exception {
        menuOption=new HashMap<String, Option>();
        mockOutput=mock(PrintStream.class);
        mockInput=mock(Input.class);
        menuOption.put("1", new OptionToBrowseBooks(mockOutput, "Browse Books", mock(List.class)));
        menuOption.put("2",new OptionToReserveBooks(mockInput,mockOutput,"Reserve Book",mock(List.class)));
        menuOption.put("3",new OptionToBrowseMovies(mockOutput,"Browse Movies",mock(List.class)));
        menuOption.put("0",new OptionToExit(mockOutput,"Exit"));
        menu = new Menu(mockInput, mockOutput, menuOption);

    }

    @Test
    public void shouldDisplayMenuOption() {
        menuOption.put("1",new Option(mockOutput, "Option 1"));
        menu.display();
        verify(mockOutput).println("1. Option 1");
    }

    @Test
    public void shouldDisplayListOfMenuOptions() {

        menu.display();

        verify(mockOutput).println("1. Browse Books");
        verify(mockOutput).println("2. Reserve Book");
        verify(mockOutput).println("3. Browse Movies");
        verify(mockOutput).println("0. Exit");
    }

    @Test
    public void shouldLetUserToPerformSelection(){
        Option mockOption=mock(Option.class);
        menuOption.put("1",mockOption);
        when(mockInput.nextInt()).thenReturn(1);
        menu=new Menu(mockInput,mockOutput,menuOption);
        menu.selectMenuOption();
        verify(mockOutput,atLeastOnce()).println("Select your choice");
        verify(mockOption).performAction();
    }
    @Test
    public void shouldDisplayErrorMsgForInvalidSelection(){
        when(mockInput.nextInt()).thenReturn(-1);
        menu.selectMenuOption();
        verify(mockOutput).println("Invalid selection");
    }
    @Test
    public void shouldDisplayErrorMsgForInvalidInput(){
        when(mockInput.nextInt()).thenReturn(99);
        menu.selectMenuOption();
        verify(mockOutput).println("Invalid selection");
    }

}
