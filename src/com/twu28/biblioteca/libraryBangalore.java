package com.twu28.biblioteca;

import java.awt.print.Book;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: SONY
 * Date: 7/26/12
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class libraryBangalore {
    public ArrayList<myBook> booksInLibrary = new ArrayList<myBook>();
    private static final int NO_OF_BOOKS = 11;

    public libraryBangalore() {
        for (int i =0 ; i < NO_OF_BOOKS ; i++){
            booksInLibrary.add(new myBook("book" + i));
        }
    }

    public boolean welcomemsg() {
        System.out.println("welcome to library");
        return true ;
    }

    public boolean showMenuOptions() {
        System.out.println("1: View Books");
        System.out.println("2: reserve particular Book");
        return true;  //To change body of created methods use File | Settings | File Templates.
    }

    public boolean viewAllBooks() {
        for (int i = 0; i<NO_OF_BOOKS; i++){
            System.out.println(booksInLibrary.get(i).getBookName());

        }

        return true;  //To change body of created methods use File | Settings | File Templates.
    }

    public boolean reserveBook(String bookname) {
        //int userOption = Integer.parseInt(option);
        boolean availability = false;// = booksInLibrary.get(userOption);
        for (int  i = 0 ; i < NO_OF_BOOKS; i++){
            myBook book_temp = booksInLibrary.get(i);
            if(bookname.equals( book_temp.getBookName())){
                availability = true;
                break;
            }
        }
        if(availability == true){
            System.out.println("Congratulation!! You Have Reserved the Book named -->" + bookname);

        }
        else {
            System.out.println("Sorry!! "+ bookname + " is not currently available");
        }
        return availability;

    }

    public boolean showLibrariansMessage() {
        System.out.println("Please talk to the Librarian!!");
        return true;
    }
}
