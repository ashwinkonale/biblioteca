package com.twu28.biblioteca;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ashwinko
 * Date: 9/14/12
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibraryBangalore {
    ArrayList<BookClass>bookList=new ArrayList<BookClass>();
    //ArrayList<BookClass>reservedBooks=new ArrayList<BookClass>();
    ArrayList<MenuOptions>menList=new ArrayList<MenuOptions>();
    public boolean welcomeMsg() {
        System.out.println("welcocme to the library!");
        return true;
    }
    public LibraryBangalore(){
        addBooks();
        addMenuOptions();
    }

    private void addMenuOptions() {
        menList.add(new MenuOptions(1,"Books"));
        menList.add(new MenuOptions(2,"Exit"));

        //To change body of created methods use File | Settings | File Templates.
    }

    public void addBooks(){
        for(int i=1;i<=10;i++){
            bookList.add(new BookClass(i,"book"+i));
        }
    }

    public void viewBooksInLibrary() {
        for (int i=0;i<10;i++){
            BookClass book_temp=bookList.get(i);
            System.out.println(book_temp);
            //reserveBook("book1");

        }
        //T" change body of created methods use File | Settings | File Templates.
    }

    public void viewMenuOptions() {
        System.out.println(menList.get(0));
        System.out.println(menList.get(1));

    }

    public boolean reserveBook(int index) {
        System.out.println("Select the index of the book to be reserved");
        //Scanner reader=new Scanner(System.in);
        //String bookname=reader.nextLine();

        boolean availability=false;
        BookClass book_temp=bookList.get(index);
        if(!book_temp.isReserved()){
           bookList.get(index).setReserved(true);
            availability=true;
        }

        if(availability){
            System.out.println("Congratulation!! You Have Reserved the Book named -->" +book_temp);

        }
        else if (availability==false) {
            System.out.println("Sorry!! "+ book_temp + " is not currently available");
        }
        return availability;
    }

    public void showLibrarianMsg() {
        System.out.println("please talk to the librarian");
    }

}
