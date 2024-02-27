package com.aston.restjdbctest.entities;

import java.util.List;
import java.util.Set;

public class Publisher {
    private int id;
    private String name;
    private Set<Book> books;

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Publisher() {}

    public Publisher(int id) {
        this.id = id;
    }

    public Publisher(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
