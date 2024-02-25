package com.aston.restjdbctest.utils;

import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper instance = Mappers.getMapper(BookMapper.class);
    BookDto toDto(Book book);
    Book toEntity(BookDto bookDto);
}
