package com.aston.restjdbctest.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.aston.restjdbctest.entities.Author} entity
 */
public class AuthorDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String book;

    public AuthorDto(String firstName, String lastName, String book) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.book = book;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBook() {
        return book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDto entity = (AuthorDto) o;
        return Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.book, entity.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, book);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "book = " + book + ")";
    }
}