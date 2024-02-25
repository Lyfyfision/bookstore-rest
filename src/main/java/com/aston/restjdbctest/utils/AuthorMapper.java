package com.aston.restjdbctest.utils;

import com.aston.restjdbctest.dto.AuthorDto;
import com.aston.restjdbctest.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper instance = Mappers.getMapper(AuthorMapper.class);
    AuthorDto toDto(Author author);
    Author toEntity(AuthorDto authorDto);
}
