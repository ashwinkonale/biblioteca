package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: ashwinko
 * Date: 9/16/12
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class MovieClass {
    String movieName;
    String director;
    String rating;
    int index;

    public MovieClass(int i, String s, String s1, String rating) {
        this.index=i;
        this.movieName=s;
        this.director=s1;
        //rating= (int) Double.parseDouble(format("%.2f",rating));
        this.rating=rating;

    }
    public String toString(){
        return index+" : "+movieName+" "+director+" "+rating+" ";
    }
}
