package com.stackroute.userprofile.repository;


import com.stackroute.userprofile.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
* This class is implementing the MongoRepository interface for User.
* Annotate this class with @Repository annotation
* */

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}

