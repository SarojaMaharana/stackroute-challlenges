package com.stackroute.newz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.newz.model.UserNews;
import org.springframework.stereotype.Repository;

/*
* This class is implementing the MongoRepository interface for UserNews.
* Annotate this class with @Repository annotation
* 
*/

@Repository
public interface UserNewsRepository  extends MongoRepository<UserNews, String>{

	
}
