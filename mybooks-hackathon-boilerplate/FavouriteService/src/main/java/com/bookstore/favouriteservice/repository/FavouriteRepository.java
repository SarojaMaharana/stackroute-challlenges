package com.bookstore.favouriteservice.repository;

import com.bookstore.favouriteservice.model.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends MongoRepository<Favourite, String> {
    List<Favourite> findAllFavouriteByUserId(String userId);
    void deleteByUserId(String userId);
    Favourite findByFavouriteIdAndUserId(String favouriteId, String userId);
}
