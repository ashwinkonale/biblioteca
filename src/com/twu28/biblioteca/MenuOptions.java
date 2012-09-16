package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: ashwinko
 * Date: 9/16/12
 * Time: 8:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuOptions {
    int number;
    String option;
    public MenuOptions(int number, String option){
        this.number=number;
        this.option=option;
    }
    public String toString(){
        return number+" : "+option;
    }

}
