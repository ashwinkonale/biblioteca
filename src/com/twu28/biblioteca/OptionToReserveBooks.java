package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class OptionToReserveBooks extends Option {
    private Input input;
    private List<Book>listOfBooks;

    public OptionToReserveBooks(Input mockInput, PrintStream output, String name, List<Book> listOfBooks) {
        super(output, name);
        this.input=mockInput;
        this.listOfBooks=listOfBooks;
    }
    public void performAction(){
        if(isLoggedIn==false){
            output.println("you need to login");
            return;
        }
        output.println("Enter the isbn of the book to be reserved");
        int isbn=input.nextInt();
        Book bookToReserve=null;
        for(Book book:listOfBooks){
            if(book.hasSameISBN(isbn)){
                bookToReserve=book;
                break;
            }
        }
        if(bookToReserve==null){
            output.println("Requested book is not available");
            return;
        }

        if(bookToReserve.isReserved()){
            output.println("sorry "+bookToReserve.display()+" is not currently available");
        }
        else {
            bookToReserve.reserve();
            output.println(bookToReserve.display() + " is reserved");
        }
    }
}
