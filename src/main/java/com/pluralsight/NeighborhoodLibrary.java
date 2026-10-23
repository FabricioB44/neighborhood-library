package com.pluralsight;
import java.util.Scanner;



public class NeighborhoodLibrary {
    private static final Scanner myScanner = new Scanner(System.in);

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


    public static void main(String[] args) {


        System.out.println("Welcome to the neighborhood library!");
        homeScreen();
        
        //libraryBooks[3].checkedOut("Fab");
        //libraryBooks[3].checkIn();
    }

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

    public static void checkOutBook(){
        System.out.println("\nPlease write the ID of the book you'd like to check out: ");
        while (true) {
            int wantedBookID = myScanner.nextInt();
            for (Book book : libraryBooks){
                if (!book.getIsCheckedOut() && wantedBookID == book.getId()){
                    myScanner.nextLine();
                    System.out.println("\nPlease write your name: ");

                    String userName = myScanner.nextLine();
                    book.checkedOut(userName);
                    homeScreen();
                    break;
                }
            }

            System.out.println("Book ID not found. \n");
            myScanner.nextLine();
            availableBooksMenu();
        }
    }

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

    public static void checkInBook(){
        System.out.println("\nPlease write the ID of the book you'd like to check in: ");
        while (true) {
            int returningBookID = myScanner.nextInt();
            for (Book book : libraryBooks){
                if (book.getIsCheckedOut() && returningBookID == book.getId()){
                    myScanner.nextLine();

                    book.checkIn();
                    homeScreen();
                    break;
                }
            }

            System.out.println("Book ID not found. \n");
            myScanner.nextLine();
            checkedOutBooksMenu();
        }
    }

}
