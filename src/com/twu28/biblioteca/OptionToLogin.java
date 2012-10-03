package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class OptionToLogin extends Option {
    private List<User>userList;
    private Input input;

    public OptionToLogin(PrintStream output, String name, Input input1, List<User> users) {
        super(output, name);
        this.input=input1;
        this.userList=users;
    }
    public void performAction(){
        if(isLoggedIn){
            output.println("You are already logged in");
            return;
        }
        User currentUser = getUsernameAndPassword();
        if(isLegitimateUser(currentUser)){
            output.println("Login successful");
        }
        else {
            output.println("Incorrect username or password");
            isLoggedIn=false;
        }
    }

    private User getUsernameAndPassword() {
        output.println("Enter Username");
        String userName=input.next();
        output.println("Enter Password");
        String password=input.next();
        return new User(userName,password);
    }

    private boolean isLegitimateUser(User currentUser) {
        for(User user:userList){
            if(currentUser.equals(user)){
                isLoggedIn=true;
                loggedInUser =currentUser;
                return true;
            }
        }
        return false;
    }
}
