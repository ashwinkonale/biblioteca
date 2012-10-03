package com.twu28.biblioteca;

import java.io.PrintStream;

public class OptionToCheckDetails extends Option{
    public OptionToCheckDetails(PrintStream output, String name) {
        super(output, name);
    }
    public void performAction(){
        if(isLoggedIn){
            output.println("Your username is "+loggedInUser.returnDetails());
        }
        else {
            output.println("Please talk to the Librarian");
        }
    }

}
