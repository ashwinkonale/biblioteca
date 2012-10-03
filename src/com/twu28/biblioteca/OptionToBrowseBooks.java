package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class OptionToBrowseBooks extends Option {
    List<Book>listOfBooks;
    public OptionToBrowseBooks(PrintStream output, String name, List<Book> listOfBooks) {
        super(output,name);
        this.listOfBooks=listOfBooks;
    }
    public void performAction(){
        for (Book book:listOfBooks){
            output.println(book.display());
        }
    }



}
