package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;

public class Menu {
    PrintStream output;
    HashMap<String,Option>options;
    Input input;
    public Menu(Input input, PrintStream output1, HashMap<String, Option> options) {
        this.output = output1;
        this.options=options;
        this.input=input;
    }

    public void display() {
        for (String optionKey:options.keySet()){
            output.println(optionKey+". "+options.get(optionKey).getName());
        }
    }

    public void selectMenuOption() {
        int choice = getUserChoice();
        if(isValidChoice(choice)){
            String key=Integer.toString(choice);
            options.get(key).performAction();
       }
        else {
            output.println("Invalid selection");
        }
    }

    private boolean isValidChoice(int choice) {
        if(choice<0||choice>options.size()){
            return false;
        }
        return true;
    }

    private int getUserChoice() {
        output.println("Select your choice");
        int choice=input.nextInt();
        return choice;
    }
}
