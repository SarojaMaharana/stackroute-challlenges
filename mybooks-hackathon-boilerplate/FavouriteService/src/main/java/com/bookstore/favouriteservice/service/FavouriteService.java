package com.bookstore.favouriteservice.service;

import com.bookstore.favouriteservice.model.Favourite;
import com.bookstore.favouriteservice.util.exception.FavouriteExistsException;
import com.bookstore.favouriteservice.util.exception.FavouriteNotPresent;

import java.util.List;

public interface FavouriteService {

    boolean createFavourite(Favourite favourite) throws FavouriteExistsException;

    boolean removeFavouriteById(String userId, String favouriteId) throws FavouriteNotPresent;

    boolean removeAllFavouritesByUserId(String userId) throws FavouriteNotPresent;

    List<Favourite> getFavouritesByUserId(String userId) throws FavouriteNotPresent;

    Favourite getFavouriteById(String userId, String favouriteId) throws FavouriteNotPresent;

}
