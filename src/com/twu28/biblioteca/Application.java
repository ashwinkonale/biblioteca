package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private Menu menu;

    public Application(Menu menu1) {
        this.menu=menu1;
    }
    public static void main(String[] args){


        List<Book>availableBooks=new ArrayList<Book>();
        availableBooks.add(new Book(1, "Immortals of meluha"));
        availableBooks.add(new Book(2,"Secret of nagas"));
        List<Movie>availableMovies=new ArrayList<Movie>();
        availableMovies.add(new Movie("snatch","director1","7.5"));
        availableMovies.add(new Movie("run","director2","8.9"));
        List<MenuOption>menuOptions=new ArrayList<MenuOption>();

        PrintStream output=System.out;
        Input input=new Input(new Scanner(System.in));

        menuOptions.add(new MenuOptionToViewBooks(output,availableBooks));
        menuOptions.add(new MenuOptionToReserveBook(input,output,availableBooks));
        menuOptions.add(new MenuOptionToViewMovies(output,availableMovies));
        menuOptions.add(new MenuOptionToLogin(input,output));

        Menu menu1=new Menu(output,input,menuOptions);

        Application application =new Application(menu1);
        application.run();

    }

    public void run() {
        while (true){
            menu.displayMenuOption();
            menu.selectMenuOption();
        }
    }
}
