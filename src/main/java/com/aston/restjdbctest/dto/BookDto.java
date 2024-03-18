package com.aston.restjdbctest.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.aston.restjdbctest.entities.Book} entity
 */
public class BookDto implements Serializable {
    private int id;
    private final String title;
    private final float price;
    private final int authorId;

    public BookDto(int id, String title, float price, int authorId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto bookDto = (BookDto) o;

        if (id != bookDto.id) return false;
        if (Float.compare(bookDto.price, price) != 0) return false;
        if (authorId != bookDto.authorId) return false;
        return title.equals(bookDto.title);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + authorId;
        return result;
    }
}