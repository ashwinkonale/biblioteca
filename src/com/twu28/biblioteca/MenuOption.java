package com.twu28.biblioteca;

import java.io.PrintStream;

public abstract class MenuOption {
    protected String menuOptionName;
    protected int indexNumber;
    protected PrintStream output;
    protected Input input;
    protected static boolean isLoggedIn;

    protected abstract void performAction();

    protected boolean hasSameIndex(int num){
        return (indexNumber==num);
    }
    protected String display(){
        return indexNumber+":"+menuOptionName;
    }
}
