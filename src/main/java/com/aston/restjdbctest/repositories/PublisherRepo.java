package com.aston.restjdbctest.repositories;

import com.aston.restjdbctest.dto.PublisherDto;
import com.aston.restjdbctest.entities.Publisher;

import java.util.List;

public interface PublisherRepo {
    void insertPublisher(PublisherDto publisher);
    void deletePublisher(int publisherId);
    void updatePublisher(Publisher publisher);
    PublisherDto getPublisher(int publisherId);
    List<Publisher> getAllPublishers();
    List<Publisher> getPublishersByBookId(int publisherId);
}
