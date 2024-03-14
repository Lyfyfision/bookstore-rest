package com.aston.restjdbctest.utils;

import com.aston.restjdbctest.dto.PublisherDto;
import com.aston.restjdbctest.entities.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {
    PublisherMapper instance = Mappers.getMapper(PublisherMapper.class);
    Publisher toEntity(PublisherDto publisherDto);
    PublisherDto toDto(Publisher publisher);
}
