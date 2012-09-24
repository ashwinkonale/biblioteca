package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class UserInterface {
    private final PrintStream output;
    private List<Book> booksAvailable;
    private final Input input;

    public UserInterface(PrintStream output, Input input, List<Book> books) {
        this.booksAvailable=books;
        this.output=output;
        this.input=input;
    }

    public void printMenuOptions() {
        output.println("Welcome to library");
        output.println("View books");
        output.println("Reserve a book");
        output.println("View movie list");
        output.println("Login");
        output.println("Exit");
    }

    public void printBooks() {
        for (Book book:booksAvailable){
            output.println(book.display());
        }
    }

    public void reserveBook() {
        output.println("Enter the isbn of the book to be reserved");
        int requestedBookISBN=input.nextInt();
        reserveBookOfISBN(requestedBookISBN);
    }

    private void reserveBookOfISBN(int requestedBookISBN) {
        Book reservedBook = null;
        for(Book book:booksAvailable){
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
