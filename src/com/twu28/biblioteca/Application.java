package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Application {
    Menu menu;
    public Application(Menu menu) {
        this.menu=menu;
    }

    public void run() {
        while (true){
            menu.display();
            menu.selectMenuOption();
        }
    }
    public static void main(String[] args){
        Input input=new Input(new Scanner(System.in));
        HashMap<String,Option>options=new HashMap<String, Option>();
        List<Book>bookList=new ArrayList<Book>();
        List<Movie>movieList=new ArrayList<Movie>();
        List<User>userList=new ArrayList<User>();

        bookList.add(new Book(1,"book1"));
        bookList.add(new Book(2,"book2"));
        bookList.add(new Book(3,"book3"));

        movieList.add(new Movie("movie 1","Director 1","5"));
        movieList.add(new Movie("movie 2","Director 2","N/A"));
        movieList.add(new Movie("movie 3","Director 3","7"));

        userList.add(new User("user1","pass1"));
        userList.add(new User("user2","pass2"));
        userList.add(new User("user3","pass3"));

        options.put("1",new OptionToBrowseBooks(System.out,"Browse Book",bookList));
        options.put("2",new OptionToReserveBooks(input,System.out,"Reserve Book",bookList));
        options.put("3",new OptionToBrowseMovies(System.out,"Browse Movies",movieList));
        options.put("4",new OptionToLogin(System.out,"Login",input,userList));
        options.put("5",new OptionToCheckDetails(System.out,"Check Details"));
        options.put("0",new OptionToExit(System.out,"Exit"));

        Menu menu=new Menu(input,System.out,options);

        Application application=new Application(menu);

        application.run();
    }
}
