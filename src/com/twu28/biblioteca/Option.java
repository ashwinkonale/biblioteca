package com.twu28.biblioteca;

import java.io.PrintStream;

public class Option {
    protected String name;
    protected PrintStream output;
    protected static boolean isLoggedIn;
    protected static User loggedInUser;

    public Option(PrintStream output, String name) {
        this.name=name;
        this.output=output;
    }

    public String getName() {
        return name;
    }


    public void performAction() {

    }


}
