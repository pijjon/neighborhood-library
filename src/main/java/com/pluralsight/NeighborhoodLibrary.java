package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Book[] inventory = new Book[20];

    }

    // each screen will be displayed by invoking a different static method
    public static void home() {
        System.out.println("""
                Store Home Screen:
                
                1 - Display Available Books
                2 - Show Checked Out Books
                3 - Exit Application
                """);

    }

    public static int askUserInt(String question) {
        System.out.println(question);
        int response = myScanner.nextInt();
        myScanner.nextLine(); // eat the line
        return response;
    }

    public static void showAvailable() {

    }

    public static void showCheckedOut() {

    }


}
