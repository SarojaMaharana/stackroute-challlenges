package com.bookstore.favouriteservice.service;

import com.bookstore.favouriteservice.model.Favourite;
import com.bookstore.favouriteservice.repository.FavouriteRepository;
import com.bookstore.favouriteservice.util.exception.FavouriteExistsException;
import com.bookstore.favouriteservice.util.exception.FavouriteNotPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    private FavouriteRepository favouriteRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @Override
    public boolean createFavourite(Favourite newFavourite) throws FavouriteExistsException {
        final Favourite favourite = favouriteRepository.findByFavouriteIdAndUserId(newFavourite.getFavouriteId(), newFavourite.getUserId());
        if(favourite == null)
            return (favouriteRepository.insert(newFavourite) != null);
        throw new FavouriteExistsException();
    }

    @Override
    public boolean removeFavouriteById(String userId, String favouriteId) throws FavouriteNotPresent {
        final Favourite favourite = favouriteRepository.findByFavouriteIdAndUserId(favouriteId, userId);
        if(favourite == null) {
            throw new FavouriteNotPresent("favourite not present");
        }
        else {
            favouriteRepository.deleteById(favouriteId);
            return true;
        }
    }

    @Override
    public boolean removeAllFavouritesByUserId(String userId) throws FavouriteNotPresent {
        final List<Favourite> favouriteList = favouriteRepository.findAllFavouriteByUserId(userId);
        if(favouriteList.isEmpty() || favouriteList == null) {
            throw new FavouriteNotPresent("favourite not present");
        }
        favouriteRepository.deleteByUserId(userId);
        return true;
    }

    @Override
    public List<Favourite> getFavouritesByUserId(String userId) throws FavouriteNotPresent {
        final List<Favourite> favouriteList = favouriteRepository.findAllFavouriteByUserId(userId);
        if(favouriteList.isEmpty() || favouriteList == null) {
            throw new FavouriteNotPresent("favourite not present");
        }
        return favouriteList;
    }

    @Override
    public Favourite getFavouriteById(String userId, String favouriteId) throws FavouriteNotPresent {
        final Favourite favourite = favouriteRepository.findByFavouriteIdAndUserId(favouriteId, userId);
        if(favourite == null)
            throw new FavouriteNotPresent("favourite not present");
        return favourite;
    }
}
