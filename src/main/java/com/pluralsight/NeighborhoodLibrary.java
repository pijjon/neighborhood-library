package com.pluralsight;

import java.util.Scanner;


public class NeighborhoodLibrary {

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


    public static void main(String[] args) {
        Book[] inventory = new Book[20];

    }

    // each screen will be displayed by invoking a different static method
    public static void home() {
        int response = askUserInt("""
                Store Home Screen:
                
                1 - Display Available Books
                2 - Show Checked Out Books
                0 - Exit Application
                """);
    }


    public static void showAvailable() {
        int response = askUserInt("""
                Available Books:
                0 - Exit to Home
                or
                Select a book to check out:
                """);
    }

    public static void showCheckedOut() {

    }


}
