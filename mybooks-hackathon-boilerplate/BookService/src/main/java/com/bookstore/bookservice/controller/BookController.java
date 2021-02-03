package com.bookstore.bookservice.controller;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.service.BookService;
import com.bookstore.bookservice.util.exception.BookAlreadyPresentException;
import com.bookstore.bookservice.util.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book newBook) throws BookAlreadyPresentException {
        return new ResponseEntity<>(bookService.addBook(newBook), HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable String bookId) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.deleteBook(bookId), HttpStatus.OK);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable String bookId, @RequestBody Book updatedBook) throws BookNotFoundException {
        updatedBook.setBookId(bookId);
        return new ResponseEntity<>(bookService.updateBook(updatedBook), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable String bookId) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getBookByTitle(@PathVariable String title) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.getBookByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<?> getAllBooksByAuthor(@PathVariable String author) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.getAllBooksByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<?> getAllBooksByPublisher(@PathVariable String publisher) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.getAllBooksByPublisher(publisher), HttpStatus.OK);
    }

}
