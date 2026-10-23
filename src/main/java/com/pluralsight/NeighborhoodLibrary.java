package com.pluralsight;
import java.util.Scanner;


public class NeighborhoodLibrary {
    private static final Scanner myScanner = new Scanner(System.in);


    // Library books are a currently a class level variable since they go on a bunch of methods and I think it's better than to be constantly passing them as arguments.
    static Book[] libraryBooks = {
            new Book(1325, "978-0141036144", "1984", true, "Potato Sensei"),
            new Book(2048, "978-0061120084", "To Kill a Mockingbird", false, ""),
            new Book(3157, "978-0743273565", "The Great Gatsby", false, ""),
            new Book(4871, "978-0316769488", "The Catcher in the Rye", true, "Potato Sensei"),
            new Book(5293, "978-0451524935", "Animal Farm", false, ""),
            new Book(6142, "978-0618640157", "The Lord of the Rings", true, "Potato Sensei"),
            new Book(7284, "978-0439708180", "Harry Potter and the Sorcerer's Stone", false, ""),
            new Book(8369, "978-0307474278", "The Girl with the Dragon Tattoo", false, ""),
            new Book(9185, "978-0385490818", "The Alchemist", true, "Potato Sensei"),
            new Book(1047, "978-1501128035", "It", true, "Potato Sensei"),
            new Book(2754, "978-0553386790", "A Game of Thrones", false, ""),
            new Book(3892, "978-0060850524", "Brave New World", true, "Potato Sensei"),
            new Book(4426, "978-0141439600", "Pride and Prejudice", true, "Potato Sensei"),
            new Book(5578, "978-0140449266", "Crime and Punishment", true, "Potato Sensei"),
            new Book(6631, "978-0544003415", "The Hobbit", false, ""),
            new Book(7745, "978-0140283334", "Of Mice and Men", false, ""),
            new Book(8824, "978-0812981605", "Gone Girl", false, ""),
            new Book(9917, "978-0307949486", "Ready Player One", true, "Potato Sensei"),
            new Book(1173, "978-1451673319", "Fahrenheit 451", true, "Potato Sensei"),
            new Book(2268, "978-1594633669", "The Kite Runner", false, "")
    };



    // In case it isn't obvious I like to keep my main classes tidy lol
    public static void main(String[] args) {
        System.out.println("Welcome to the neighborhood library!");
        homeScreen();
    }


    // Main menu, made it a method so it can be called from any other menus
    public static void homeScreen(){
        System.out.println("\nWhat would you like to do?");
        System.out.println("1: Show available books.");
        System.out.println("2: Show checked out books.");
        System.out.println("3: Exit library.");
        switch (myScanner.nextLine()) {
            case "1":
                showAvailableBooks();
                break;
            case "2":
                showCheckedOutBooks();
                break;
            case "3":
                System.out.println("\nThank you for visiting the Neighborhood Library. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input, please try again: ");
                homeScreen();
                break;
        }
    }


    // Since the list is pretty long, I split it and it's respective menu apart so that this long list is not constantly getting printed
    public static void showAvailableBooks(){
        System.out.println("\nBooks available for check out: \n");
        for (Book book : libraryBooks) {
            if (!book.getIsCheckedOut()) {
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println();
            }
        }
        availableBooksMenu();
    }


    // Menu that goes under the available books list, it also gets called by itself in case of invalid inputs.
    public static void availableBooksMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1: Check out a book.");
        System.out.println("2: Go back to home screen.");
        System.out.println("3: Exit library.");

        switch (myScanner.nextLine()) {
            case "1":
                checkOutBook();
                break;
            case "2":
                homeScreen();
                break;
            case "3":
                System.out.println("\nThank you for visiting the Neighborhood Library. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input, please try again.");
                availableBooksMenu();
                break;
        }
    }


    // Book check out method, it uses the checkedOut method defined within Book.java
    public static void checkOutBook(){
        System.out.println("\nPlease write the ID of the book you'd like to check out: ");
        while (true) {
            if (!myScanner.hasNextInt()) {
                myScanner.nextLine(); // remove the bad input
                System.out.println("Book ID not found.\n");
                availableBooksMenu();
                return;
            }

            int wantedBookID = myScanner.nextInt();
            for (Book book : libraryBooks){
                if (!book.getIsCheckedOut() && wantedBookID == book.getId()){
                    myScanner.nextLine();
                    System.out.println("\nPlease write your name: ");

                    String userName = myScanner.nextLine();
                    book.checkedOut(userName);
                    homeScreen();
                    return;
                }
            }

            System.out.println("Book ID not found. \n");
            myScanner.nextLine();
            availableBooksMenu();
        }
    }


    // All the checked out Book lists and menus work the same way as the available in ones only with slight variations, there's probably some code repetition that could be improved
    public static void showCheckedOutBooks(){
        System.out.println("\nBooks currently checked out: \n");
        for (Book book : libraryBooks) {
            if (book.getIsCheckedOut()) {
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println();
            }
        }
        checkedOutBooksMenu();
    }


    public static void checkedOutBooksMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1: Check in a book.");
        System.out.println("2: Go back to home screen.");
        System.out.println("3: Exit library.");

        switch (myScanner.nextLine()) {
            case "1":
                checkInBook();
                break;
            case "2":
                homeScreen();
                break;
            case "3":
                System.out.println("\nThank you for visiting the Neighborhood Library. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input, please try again.");
                availableBooksMenu();
                break;
        }
    }

    // uses the checkIn() method defined in Book.java
    public static void checkInBook(){
        System.out.println("\nPlease write the ID of the book you'd like to check in: ");
        while (true) {
            if (!myScanner.hasNextInt()) {
                myScanner.nextLine(); // remove the bad input
                System.out.println("Book ID not found.\n");
                availableBooksMenu();
                return;
            }

            int returningBookID = myScanner.nextInt();
            for (Book book : libraryBooks){
                if (book.getIsCheckedOut() && returningBookID == book.getId()){
                    myScanner.nextLine();

                    book.checkIn();
                    homeScreen();
                    return;
                }
            }

            System.out.println("Book ID not found. \n");
            myScanner.nextLine();
            checkedOutBooksMenu();
        }
    }

}
