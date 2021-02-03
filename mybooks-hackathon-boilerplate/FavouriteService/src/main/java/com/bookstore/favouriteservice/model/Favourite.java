package com.bookstore.favouriteservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Favourite {

    @Id
    private String favouriteId;
    private String userId;
    private String bookId;

    public Favourite() {
    }

    public Favourite(String favouriteId, String userId, String bookId) {
        this.favouriteId = favouriteId;
        this.userId = userId;
        this.bookId = bookId;
    }

    public String getFavouriteId() {
        return favouriteId;
    }

    public void setFavouriteId(String favouriteId) {
        this.favouriteId = favouriteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "favouriteId='" + favouriteId + '\'' +
                ", userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }

}
