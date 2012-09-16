package com.twu28.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: SONY
 * Date: 7/26/12
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class test {

    @Test
    public void canShowWelcomeMessage(){
        LibraryBangalore library =   new LibraryBangalore();
           assertTrue(library.welcomeMsg());
    }
    @Test
    public void ViewBooks(){
       LibraryBangalore libraryBangalore=new LibraryBangalore();
        libraryBangalore.viewBooksInLibrary();
    }
    @Test
    public void testViewMenuOptions(){
        LibraryBangalore libraryBangalore=new LibraryBangalore();
        libraryBangalore.viewMenuOptions();

    }
    @Test
    public void testReserveBook(){
        LibraryBangalore libraryBangalore=new LibraryBangalore();
        assertTrue(libraryBangalore.reserveBook(2));
        libraryBangalore.viewBooksInLibrary();
        assertFalse(libraryBangalore.reserveBook(2));
    }
    @Test
    public void showLibrarianMsg(){
        LibraryBangalore libraryBangalore=new LibraryBangalore();
        libraryBangalore.showLibrarianMsg();
    }



}
