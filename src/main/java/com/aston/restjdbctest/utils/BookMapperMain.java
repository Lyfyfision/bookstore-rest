package com.aston.restjdbctest.utils;

import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.entities.Author;
import com.aston.restjdbctest.entities.Book;
import com.aston.restjdbctest.entities.Publisher;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapperMain {
//    public static BookDto toDTO(Book book) {
//        BookDto bookDTO = new BookDto();
//        bookDTO.setId(book.getId());
//        // Convert List of Author objects to List of authorIds
//        List<Integer> authorIds = book.getAuthors().stream()
//                .map(Author::getId)
//                .collect(Collectors.toList());
//        bookDTO.setAuthorIds(authorIds);
//        // Convert List of Publisher objects to List of publisherIds
//        List<Integer> publisherIds = book.getPublishers().stream()
//                .map(Publisher::getId)
//                .collect(Collectors.toList());
//        bookDTO.setPublisherIds(publisherIds);
//        bookDTO.setTitle(book.getTitle());
//        bookDTO.setPrice(book.getPrice());
//        return bookDTO;
//    }
}
