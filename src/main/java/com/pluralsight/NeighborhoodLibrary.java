package com.pluralsight;

import java.beans.beancontext.BeanContextServiceAvailableEvent;
import java.util.Scanner;


public class NeighborhoodLibrary {

    public static Book[] inventory = new Book[20];

    public static void main(String[] args) {
        inventory[0] = new Book(1, "978-0143127741", "The Martian", false, null);
        inventory[1] = new Book(2, "978-0062316097", "Sapiens", true, "Alice");
        inventory[2] = new Book(3, "978-0553382563", "The Road", false, null);
        inventory[3] = new Book(4, "978-0307887443", "Ready Player One", true, "Bob");
        inventory[4] = new Book(5, "978-0385545969", "Project Hail Mary", false, null);
        inventory[5] = new Book(6, "978-1501124020", "The Silent Patient", true, "Charlie");
        inventory[6] = new Book(7, "978-0451524935", "1984", false, null);
        inventory[7] = new Book(8, "978-0743273565", "The Great Gatsby", true, "Dana");
        inventory[8] = new Book(9, "978-0060850524", "Brave New World", false, null);
        inventory[9] = new Book(10, "978-0141182803", "Animal Farm", true, "Evan");
        inventory[10] = new Book(11, "978-0061120084", "To Kill a Mockingbird", false, null);
        inventory[11] = new Book(12, "978-0140449136", "The Odyssey", true, "Fiona");
        inventory[12] = new Book(13, "978-0143039433", "The Kite Runner", false, null);
        inventory[13] = new Book(14, "978-0060853983", "The Alchemist", true, "George");
        inventory[14] = new Book(15, "978-0307277671", "The Girl with the Dragon Tattoo", false, null);
        inventory[15] = new Book(16, "978-0374533557", "The Power of Habit", true, "Hannah");
        inventory[16] = new Book(17, "978-0142424179", "The Fault in Our Stars", false, null);
        inventory[17] = new Book(18, "978-0385537858", "Inferno", true, "Ian");
        inventory[18] = new Book(19, "978-0525555374", "Where the Crawdads Sing", false, null);
        inventory[19] = new Book(20, "978-0143038412", "Life of Pi", true, "Julia");
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
        boolean isRunning = true; // boolean flag to keep display running UNTIL user exits


        // while loop constantly displays the screen until user exits back to home
        while (isRunning) {
            // header for screen
            System.out.println("Available Books");

            // create new array for list of available books for more time efficient manipulation later
            Book[] available = new Book[inventory.length];

            // keep track of how many books are in the array
            int availableCount = 0;

            // iterate through book array and fill available array if book is not checked out + display available books
            for (Book book : inventory) {
                if (!book.getIsCheckedOut()) {
                    available[availableCount++] = book;
                    System.out.printf("\n%d) ID: %d Title: %s ISBN: %s", availableCount, book.getId(), book.getTitle(), book.getIsbn());
                }
            }

            //prompt user for a selection
            String response = askUserStr("""
                    Select a book to check out
                    or
                    X - Exit to Home
                    
                    Select:
                    """);

            // if user selects "x" then we exit to home, else we prompt user for their name and checkOut the book they selected without relooping
            if (response.equalsIgnoreCase("x")) {
                isRunning = false;
            }
            else {
                String name = askUserStr("What is your name?");
                available[Integer.parseInt(response) - 1].checkOut(name);

            }
        }
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
