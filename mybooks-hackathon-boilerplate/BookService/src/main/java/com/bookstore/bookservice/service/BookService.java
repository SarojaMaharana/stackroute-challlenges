package com.bookstore.bookservice.service;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.util.exception.BookAlreadyPresentException;
import com.bookstore.bookservice.util.exception.BookNotFoundException;

import java.util.List;

public interface BookService {

    boolean addBook(Book book) throws BookAlreadyPresentException;

    boolean deleteBook(String bookId) throws BookNotFoundException;

    Book updateBook(Book book) throws BookNotFoundException;

    Book getBookById(String bookId) throws BookNotFoundException;

    Book getBookByTitle(String title) throws BookNotFoundException;

    List<Book> getAllBooksByAuthor(String author) throws BookNotFoundException;

    List<Book> getAllBooksByPublisher(String publisher) throws BookNotFoundException;

}
