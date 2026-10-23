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
        System.out.printf("\nBook #%d, %s, has been checked out by %s", this.id, this.title, name);
    }

    public void checkIn() {
        System.out.printf("\nBook #%d, %s, has been checked back in by %s", this.id, this.title, this.checkedOutTo);
        this.checkedOutTo = "";
        this.isCheckedOut = false;

    }
}
