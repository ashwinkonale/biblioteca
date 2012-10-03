package com.twu28.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class OptionTest {
    protected PrintStream mockOutput;
    protected Input mockInput;
    @Test
    public void shouldPrintOption(){
        mockOutput =mock(PrintStream.class);
        Option option=new Option(mockOutput,"some option");
        assertEquals(option.getName(),"some option");
    }
}
