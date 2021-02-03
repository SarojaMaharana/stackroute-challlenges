package com.bookstore.favouriteservice.controller;

import com.bookstore.favouriteservice.model.Favourite;
import com.bookstore.favouriteservice.service.FavouriteService;
import com.bookstore.favouriteservice.util.exception.FavouriteExistsException;
import com.bookstore.favouriteservice.util.exception.FavouriteNotPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/favourite")
public class FavouriteController {

    private FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping
    public ResponseEntity<?> addFavourite(@RequestBody Favourite newFavourite) throws FavouriteExistsException {
        return new ResponseEntity<>(favouriteService.createFavourite(newFavourite), HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{favouriteId}")
    public ResponseEntity<?> deleteByFavouriteId(@PathVariable("userId") String userId, @PathVariable("favouriteId") String favouriteId) throws FavouriteNotPresent {
        return new ResponseEntity<>(favouriteService.removeFavouriteById(userId, favouriteId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteAllFavouritesByUser(@PathVariable("userId") String userId) throws FavouriteNotPresent {
        return new ResponseEntity<>(favouriteService.removeAllFavouritesByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{favouriteId}")
    public ResponseEntity<?> getFavouriteById(@PathVariable("userId") String userId, @PathVariable("favouriteId") String favouriteId) throws FavouriteNotPresent {
        return new ResponseEntity<>(favouriteService.getFavouriteById(userId, favouriteId), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getFavouriteByUserId(@PathVariable("userId") String userId) throws FavouriteNotPresent {
        return new ResponseEntity<>(favouriteService.getFavouritesByUserId(userId), HttpStatus.OK);
    }
}
