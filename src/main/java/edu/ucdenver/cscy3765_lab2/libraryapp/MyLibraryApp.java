package edu.ucdenver.cscy3765_lab2.libraryapp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import edu.ucdenver.cscy3765_lab2.library.*;
import java.time.LocalDate;

public class MyLibraryApp {

    /*
     * List team members here:
     * 1)
     * 2)
     * 3)
     * 4)
     */


    /**
     * This is a sample program that will use the Library.
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean isSignedIn = false;
        Library myLibrary = new Library("My Auraria Library");

        while(!isSignedIn){
            System.out.print("1. Sign in\n2. Create account\n3. Exit\nSelect: ");
            int option = input.nextInt();

            if (option == 1){
                System.out.print("Username: ");
                String username = input.next();

                System.out.print("Password: ");
                String password = input.next();

                System.out.print("Authentication Code: ");
                String verificationCode = input.next();

                try{
                    myLibrary.logIn(username, password, verificationCode);
                    isSignedIn = true;
                } catch (IllegalArgumentException e){
                    System.err.println(e.getMessage());
                }


            }
            else if (option == 2) {
                    System.out.println("\nCreate new User:");
                    System.out.print("Username: ");
                    String username = input.next();

                    System.out.print("Password: ");
                    String password = input.next();

                    System.out.print("Email: ");
                    String email = input.next();

                    try {
                        myLibrary.signUp(username, password, email);
                    } catch (IllegalArgumentException e){
                        System.err.println(e.getMessage());
                    }
            } else if (option == 3) {
                break;
            }
        }

        if (isSignedIn) {

            System.out.println(">>>>>>>>>>>>>>>>>>");
            System.out.println(myLibrary);
            System.out.println("<<<<<<<<<<<<<<<<<<");

            try {
                myLibrary.addAuthor("John Grisham");
            } catch (IllegalArgumentException ie) {
                System.out.println("ERROR:" + ie);
            }

            try {
                myLibrary.addAuthor("David Baldacci");
            } catch (IllegalArgumentException ie) {
                System.out.println("ERROR:" + ie);
            }

            try {
                myLibrary.addAuthor("John Grisham");
            } catch (IllegalArgumentException ie) {
                System.out.println("ERROR:" + ie);
            }

            System.out.println(">>>>>>>>>>>>>>>>>>");
            System.out.println(myLibrary);
            System.out.println("<<<<<<<<<<<<<<<<<<");

            try {
                String[] titles = {"The Guardians: A Novel", "Guardians", "Guardianes"};
                myLibrary.addBook("The Guardians", LocalDate.of(2019, 10, 15), titles, "John Grisham", 120);
            } catch (IllegalArgumentException ie) {
                System.out.println("ERROR:" + ie);
            }

            try {
                String[] titles = {"b1", "book 1", "the title of book 1"};
                myLibrary.addBook("Book 1", LocalDate.of(2000, 1, 1), titles, "Al. Baker", 120);
            } catch (IllegalArgumentException ie) {
                System.out.println("ERROR:" + ie);
            }

            try {
                String[] titles = {"Camino Winds", "Winds", "The last one"};
                myLibrary.addBook("Camino Winds", LocalDate.of(2020, 4, 28), titles, "John Grisham", 300);
            } catch (IllegalArgumentException ie) {
                System.out.println("ERROR:" + ie);
            }
            System.out.println(">>>>>>>>>>>>>>>>>>");
            System.out.println(myLibrary);
            System.out.println("<<<<<<<<<<<<<<<<<<");
        }
    }
}

/*
*** This is the sample of executing this program.
/Library/Java/JavaVirtualMachines/jdk1.8.0_261.jdk/Contents/Home/bin/java ..........
>>>>>>>>>>>>>>>>>>
This is the My Auraria Library library.
== Author List ==
== Book List ==
--o--
<<<<<<<<<<<<<<<<<<
ERROR:java.lang.IllegalArgumentException: The author already exists.
>>>>>>>>>>>>>>>>>>
This is the My Auraria Library library.
== Author List ==
John Grisham (Author)
David Baldacci (Author)
== Book List ==
--o--
<<<<<<<<<<<<<<<<<<
ERROR:java.lang.IllegalArgumentException: The author name does not exists
>>>>>>>>>>>>>>>>>>
This is the My Auraria Library library.
== Author List ==
John Grisham (Author)
David Baldacci (Author)
== Book List ==
Book: The Guardians,  with 120 pages published on 2019-10-15 written by John Grisham (Author).
   a.k.a:The Guardians: A Novel
   a.k.a:Guardians
   a.k.a:Guardianes

Book: Camino Winds,  with 300 pages published on 2020-04-28 written by John Grisham (Author).
   a.k.a:Camino Winds
   a.k.a:Winds
   a.k.a:The last one

--o--
<<<<<<<<<<<<<<<<<<

Process finished with exit code 0
 */