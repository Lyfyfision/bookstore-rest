package com.aston.restjdbctest.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.aston.restjdbctest.entities.Book} entity
 */
public class BookDto implements Serializable {
    private final String title;
    private final String author;
    private final float price;

    public BookDto(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto entity = (BookDto) o;
        return Objects.equals(this.title, entity.title) &&
                Objects.equals(this.author, entity.author) &&
                Objects.equals(this.price, entity.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "title = " + title + ", " +
                "author = " + author + ", " +
                "price = " + price + ")";
    }
}