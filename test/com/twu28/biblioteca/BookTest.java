package com.twu28.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {
    Book testBook;
    @Before
    public void setUp() throws Exception {
        testBook=new Book(2341,"Game of thrones");

    }

    @Test
    public void testDisplay() throws Exception {
        assertEquals(testBook.display(),"2341 : Game of thrones");

    }

    @Test
    public void testHasSameISBN() throws Exception {
        assertTrue(testBook.hasSameISBN(2341));

    }

    @Test
    public void testIsReserved() throws Exception {

    }

    @Test
    public void testReserve() throws Exception {

    }
}
