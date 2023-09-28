package edu.ucdenver.cscy3765_lab2;

import edu.ucdenver.cscy3765_lab2.library.Library;

import java.util.Scanner;

/**
 * This class is meant to allow you to test your functions implemented in `Library` and `User` for this lab. It doesn't
 * interact with the LoginServlet or the SignupServlet API classes. This should help you make sure your methods from the
 * `Library` and `User` classes are fully functional before you move on to linking them into the website.
 * If you already moved on and are still experiencing bugs, checking if the signup and login are working
 * *NOTE: The `Library` object created by running this class and the one created by Tomcat are **NOT** the same object.
 * Adding `User`s through here and trying to log in with the server site won't work.
 */
public class ConsoleTester {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean isSignedIn = false;
        Library myLibrary = Library.initTesterLibrary();

        while (!isSignedIn) {
            System.out.print("1. Sign in\n2. Create account\n3. Output User List\n4. Exit\nSelect: ");
            int option = input.nextInt();

            if (option == 1) {
                System.out.print("Username: ");
                String username = input.next();

                System.out.print("Password: ");
                String password = input.next();

                System.out.print("Authentication Code: ");
                String verificationCode = input.next();

                try {
                    myLibrary.logIn(username, password, verificationCode);
                    isSignedIn = true;
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }


            } else if (option == 2) {
                System.out.println("\nCreate new User:");
                System.out.print("Username: ");
                String username = input.next();

                System.out.print("Password: ");
                String password = input.next();

                System.out.print("Email: ");
                String email = input.next();

                try {
                    myLibrary.signUp(username, password, email);
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            } else if(option == 3) {
                myLibrary.printUsers();
            } else if (option == 4) {
                break;
            }
        }

        if (isSignedIn) {
            System.out.println("LOGIN SUCCESSFUL!");
            System.out.println(">>>>>>>>>>>>>>>>>>");
            System.out.println(myLibrary);
            System.out.println("<<<<<<<<<<<<<<<<<<");

        }
    }
}
