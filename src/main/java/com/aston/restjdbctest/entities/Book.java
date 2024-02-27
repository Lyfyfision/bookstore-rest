package com.aston.restjdbctest.entities;

import java.util.List;

public class Book {
    private int id;
    private String title;
    private float price;
    private int authorId;
    private int publisherId;
    private List<Publisher> publishers;
    private List<Author> authors;

    public Book() {
    }

    public Book(int id, String title, float price, int authorId, int publisherId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.authorId = authorId;
        this.publisherId = publisherId;
    }

    public Book(String title, float price, int authorId, int publisherId) {
        this.title = title;
        this.price = price;
        this.authorId = authorId;
        this.publisherId = publisherId;
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
}
