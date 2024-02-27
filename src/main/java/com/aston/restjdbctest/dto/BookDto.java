package com.aston.restjdbctest.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.aston.restjdbctest.entities.Book} entity
 */
public class BookDto implements Serializable {
    private final int id;
    private final String title;
    private final float price;
    private final int authorId;
    private final int publisherId;

    public BookDto(int id, String title, float price, int authorId, int publisherId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.publisherId = publisherId;
        this.authorId = authorId;
    }
    public int getId() {
        return id;
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

    public int getPublisherId() {
        return publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto bookDto = (BookDto) o;

        if (id != bookDto.id) return false;
        if (Float.compare(bookDto.price, price) != 0) return false;
        if (authorId != bookDto.authorId) return false;
        if (publisherId != bookDto.publisherId) return false;
        return title.equals(bookDto.title);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + authorId;
        result = 31 * result + publisherId;
        return result;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", authorId=" + authorId +
                ", publisherId=" + publisherId +
                '}';
    }
}