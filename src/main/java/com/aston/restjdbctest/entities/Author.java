package com.aston.restjdbctest.entities;

public class Author {

    private int id;
    private String firstName;
    private String lastName;
    private String book;

    public Author(int id, String firstName, String lastName, String book) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.book = book;
    }

    public Author() {}

    public Author(String firstName, String lastName, String book) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
