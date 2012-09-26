package com.twu28.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Menu {
    private PrintStream output;
    private Input input;
    private List<MenuOption>menuOptionList;
    public Menu(PrintStream output, Input input, List<MenuOption> menuOptions){
        this.output=output;
        this.input=input;
        this.menuOptionList=menuOptions;
    }

    public void displayMenuOption(){
        for (MenuOption menuOption:menuOptionList){
            output.println(menuOption.display());
        }
    }

    public void selectMenuOption() {

        int choice=input.nextInt();
        MenuOption optionSelected = null;
        for(MenuOption menuOption:menuOptionList){
            if(menuOption.hasSameIndex(choice)){
                optionSelected=menuOption;
            }
        }
        if(optionSelected==null){
            output.println("Enter Valid option");
            return;
        }
        optionSelected.performAction();

    }
}
