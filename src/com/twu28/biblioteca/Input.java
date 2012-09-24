package com.twu28.biblioteca;

import java.util.Scanner;

public class Input {
    private Scanner scanner;
    public Input(Scanner scanner){
        this.scanner=scanner;
    }
    public int nextInt(){
        return scanner.nextInt();
    }
}
