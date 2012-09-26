package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class MenuOptionToViewBooks extends MenuOption {
    protected List<Book> books;
    public MenuOptionToViewBooks(PrintStream output, List<Book> books){
        this.books=books;
        this.output=output;
        menuOptionName="View Books";
        indexNumber=1;
    }
    public void performAction() {
        for(Book book:books){
            output.println(book.display());
        }
    }

}
