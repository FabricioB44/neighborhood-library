package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void checkedOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
        System.out.printf("\nBook #%d, %s, has been checked out by %s\n", this.id, this.title, name);
    }

    public void checkIn() {
        System.out.printf("\nBook #%d, %s, has been checked back in by %s\n", this.id, this.title, this.checkedOutTo);
        this.checkedOutTo = "";
        this.isCheckedOut = false;

    }


    // the individual setters don't get used in this code but I figured I'd declare them just in case since the project description asks for it.

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
}
