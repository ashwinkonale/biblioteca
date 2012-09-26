package com.twu28.biblioteca;

import java.io.PrintStream;

public class MenuOptionToLogin extends MenuOption {
    public MenuOptionToLogin(Input input, PrintStream output) {
        this.input=input;
        this.output=output;
        menuOptionName="Login";
        indexNumber=4;
    }

    @Override
    protected void performAction() {
        if(!isLoggedIn){
            output.println("Enter Username");
            String userName=input.next();
            output.println("Enter Password");
            String password=input.next();
            boolean isValidUser=testValidity(userName,password);
            if(isValidUser){
                output.println("Login successful");
                isLoggedIn=true;
            }
            else {
                output.println("Incorrect Username or password");
            }
        }
        else {
            output.println("You are already logged in");
        }
    }

    private boolean testValidity(String userName, String password) {
        if(userName.equals("ashwin")&&password.equals("pass1")){
            return true;
        }
        return false;
    }
}
