package com.bookstore.bookservice.service;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.repository.BookRepository;
import com.bookstore.bookservice.util.exception.BookAlreadyPresentException;
import com.bookstore.bookservice.util.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean addBook(Book book) throws BookAlreadyPresentException {
        final Optional<Book> optionalBook = bookRepository.findById(book.getBookId());
        if(optionalBook.isPresent()) {
            throw new BookAlreadyPresentException();
        } else if (bookRepository.findByTitle(book.getTitle()) !=null) {
            throw new BookAlreadyPresentException();
        }
        return (bookRepository.insert(book) != null);
    }

    @Override
    public boolean deleteBook(String bookId) throws BookNotFoundException {
        final Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()) throw new BookNotFoundException();
        bookRepository.deleteById(bookId);
        return true;
    }

    @Override
    public Book updateBook(Book book) throws BookNotFoundException {
        final Optional<Book> optionalBook = bookRepository.findById(book.getBookId());
        if(optionalBook.isEmpty()) throw new BookNotFoundException();
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book getBookById(String bookId) throws BookNotFoundException {
        final Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()) throw new BookNotFoundException();
        return optionalBook.get();
    }

    @Override
    public Book getBookByTitle(String title) throws BookNotFoundException {
        final Book getBook = bookRepository.findByTitle(title);
        if (getBook == null)
            throw new BookNotFoundException();
        return getBook;
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) throws BookNotFoundException {
        final List<Book> bookList = bookRepository.findAllBookByAuthor(author);
        if (bookList == null || bookList.isEmpty())
            throw new BookNotFoundException();
        return bookList;
    }

    @Override
    public List<Book> getAllBooksByPublisher(String publisher) throws BookNotFoundException {
        final List<Book> bookList = bookRepository.findAllBookByPublisher(publisher);
        if (bookList == null || bookList.isEmpty())
            throw new BookNotFoundException();
        return bookList;
    }
}
