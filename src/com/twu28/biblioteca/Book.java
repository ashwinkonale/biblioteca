package com.twu28.biblioteca;

public class Book {
    private int isbn;
    private String bookName;
    private boolean isReserved;

    public Book(int isbn, String bookName) {
        this.bookName=bookName;
        this.isbn=isbn;
    }
    public String display(){
        return isbn+" : "+bookName;
    }

    public boolean hasSameISBN(int requestedBookISBN) {
        return (isbn==requestedBookISBN);
    }

    public boolean isReserved() {
        return isReserved;
    }
    public void reserve(){
        this.isReserved =true;
    }
}
