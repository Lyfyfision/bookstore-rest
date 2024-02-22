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
}
