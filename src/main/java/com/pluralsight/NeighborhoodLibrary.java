package com.pluralsight;

import java.beans.beancontext.BeanContextServiceAvailableEvent;
import java.util.Scanner;


public class NeighborhoodLibrary {

    public static Book[] inventory = new Book[20];

    public static void main(String[] args) {

        home();
    }

    // each screen will be displayed by invoking a different static method
    public static void home() {
        boolean isRunning = true;

        while (isRunning) {
            String response = askUserStr("""
                    Store Home Screen
                    
                    1 - Display Available Books
                    2 - Show Checked Out Books
                    X - Exit Application
                    """);

            switch (response.toLowerCase()) {
                case "1":
                    showAvailable();
                    break;

                case "2":
                    showCheckedOut();
                    break;

                case "x":
                    isRunning = false;
                    break;

                default:
                    System.out.println("wthelly");
            }

        }
    }

    public static void showAvailable() {
        boolean isRunning = true;
        System.out.println("Available Books");
        while (isRunning) {
            for (Book book : inventory) {
                System.out.printf("ID: %d Title: %s ISBN: %s", book.getId(), book.getTitle(), book.getIsbn());
            }
            String response = askUserStr("""
                    X - Exit to Home
                    or
                    To check out a book, provide the ID:
                    """);

            if (response.equalsIgnoreCase("x")) {
                isRunning = false;
            }
            else {
                String name = askUserStr("What is your name?");
                for (Book book : inventory) {
                    if (book.getId() == Integer.getInteger(response)) {
                        book.checkOut(name);
                    }
                }
            }


        }

        // checkout the book, then prompt user if they wanna check out another book
        // if yes, showAvailable();
        // else return;
    }

    public static void showCheckedOut() {
        String response = askUserStr("""
                Checked Out Books
                
                X - Exit to Home
                or
                C - Check in one of these books:
                """);
    }

    public static Scanner myScanner = new Scanner(System.in);

    public static int askUserInt(String question) {
        System.out.println(question);
        int response = myScanner.nextInt();
        myScanner.nextLine(); // eat the line
        return response;
    }

    public static String askUserStr(String question) {
        System.out.println(question);
        return myScanner.nextLine();
    }


}
