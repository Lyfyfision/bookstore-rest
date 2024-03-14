package com.aston.restjdbctest.entities;

import java.util.List;

public class Book {
    private int id;
    private String title;
    private float price;
    private int authorId;
    private List<Publisher> publishers;

    public Book() {
    }

    public Book(int id, String title, float price, int authorId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.authorId = authorId;
    }

    public Book(String title, float price, int authorId) {
        this.title = title;
        this.price = price;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
