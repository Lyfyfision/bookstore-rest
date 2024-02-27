package com.aston.restjdbctest.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.aston.restjdbctest.entities.Author} entity
 */
public class AuthorDto implements Serializable {
    private final int id;
    private final String name;

    public AuthorDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorDto authorDto = (AuthorDto) o;

        if (id != authorDto.id) return false;
        return name.equals(authorDto.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}