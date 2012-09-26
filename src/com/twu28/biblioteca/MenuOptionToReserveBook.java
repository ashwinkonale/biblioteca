package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class MenuOptionToReserveBook extends MenuOption {

    protected List<Book> books;

    public MenuOptionToReserveBook(Input input, PrintStream out, List<Book> booksAvailable) {
        this.books=booksAvailable;
        this.output=out;
        this.input=input;
        menuOptionName="Reserve a book";
        indexNumber=2;
    }

    protected void performAction() {
        if(isLoggedIn){
            output.println("Enter the isbn of the book to be reserved");
            int requestedBookISBN=input.nextInt();
            reserveBookOfISBN(requestedBookISBN);
        }
        else {
            output.println("U need to login");
        }
    }

    private void reserveBookOfISBN(int requestedBookISBN) {
        Book reservedBook = null;
        for(Book book:books){
            if(book.hasSameISBN(requestedBookISBN)){
                reservedBook=book;
            }
        }
        if(reservedBook==null){
            output.println("Sorry we don't have that book yet");
            return;
        }
        if(reservedBook.isReserved()){
            output.println(reservedBook.display()+" is not currently available");

        }
        else {
            output.println("U hv reserved book -->"+reservedBook.display());
            reservedBook.reserve();
        }
    }
}
