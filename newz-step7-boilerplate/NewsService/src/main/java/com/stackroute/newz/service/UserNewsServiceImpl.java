package com.stackroute.newz.service;


/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */

import com.stackroute.newz.model.UserNews;
import com.stackroute.newz.repository.UserNewsRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserNewsServiceImpl  implements UserNewsService {

	private UserNewsRepository userNewsRepository;

	/*
	 * Autowiring should be implemented for the UserNewsRepository and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	@Autowired
	public UserNewsServiceImpl(UserNewsRepository userNewsRepository) {
		this.userNewsRepository = userNewsRepository;
	}

	@RabbitListener(queues = "user.new.queue")
	private void addNewUser(String userId) {
		UserNews userNews = new UserNews(userId, new ArrayList<>());
		userNewsRepository.insert(userNews);
	}

	/* This method should be used to delete all news for a  specific userId. */

	@Override
	public void deleteAllNewsBySource(String userId, String newsSourceId) {
			
	}

}
