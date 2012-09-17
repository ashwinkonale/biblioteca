package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: ashwinko
 * Date: 9/16/12
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserInterface {
    public static void main(String [] args){
        LibraryBangalore libraryBangalore=new LibraryBangalore();
        while(true){
        libraryBangalore.viewMenuOptions();
            //Scanner userInput1=new Scanner(System.in);
            //int userInput=userInput1.nextInt();
            int userInput=1;

        switch (userInput){
            case 1:
            libraryBangalore.viewBooksInLibrary();
                libraryBangalore.reserveBook(3);
                System.out.println("So u want to reserve one more book? y/n");
                //scanner
                String choice="y";
                choice.toLowerCase();
                if(choice.equals("y")){
                    libraryBangalore.reserveBook(3);
                }
                if(choice.equals("n")){
                    break;
                }
                break;
            case 2:
                libraryBangalore.viewMovies();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Select a valid menu option !!");


        }
      }


    }
}
