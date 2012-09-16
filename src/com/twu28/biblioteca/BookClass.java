package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: ashwinko
 * Date: 9/14/12
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookClass {
    private String bookName;
    private int index;
    private boolean isReserved;

    public BookClass(int index,String bookName) {
        setBookName(bookName);
        this.index=index;

    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String toString(){
        return index+" : "+bookName;
    }
    public boolean equals(Object book){
        BookClass bookTemp=(BookClass)book;
        return getBookName().equals(bookTemp.getBookName());
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
