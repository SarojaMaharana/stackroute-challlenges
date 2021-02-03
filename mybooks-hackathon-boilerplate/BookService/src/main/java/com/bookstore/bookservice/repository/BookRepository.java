package com.bookstore.bookservice.repository;

import com.bookstore.bookservice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Book findByTitle(String title);
    List<Book> findAllBookByAuthor(String author);
    List<Book> findAllBookByPublisher(String publisher);
}
