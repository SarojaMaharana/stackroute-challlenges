package com.stackroute.newz.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.newz.model.NewsSource;
import com.stackroute.newz.repository.NewsSourceRepository;
import com.stackroute.newz.util.exception.NewsSourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */

@Service
public class NewsSourceServiceImpl implements NewsSourceService {

	private NewsSourceRepository newsSourceRepository;

	/*
	 * Autowiring should be implemented for the NewsDao and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	@Autowired
	public NewsSourceServiceImpl(NewsSourceRepository newsSourceRepository) {
		this.newsSourceRepository = newsSourceRepository;
	}

	/*
	 * This method should be used to save a newsSource.
	 */

	@Override
	public boolean addNewsSource(NewsSource newsSource) {
//		newsSourceRepository.save(newsSource);
		return (newsSourceRepository.insert(newsSource) != null);
//		return true;
	}

	/* This method should be used to delete an existing newsSource. */

	@Override
	public boolean deleteNewsSource(int newsSourceId) {
		final Optional<NewsSource> optionalNewsSource = newsSourceRepository.findById(newsSourceId);
		try {
			if (optionalNewsSource.isPresent()) {
				newsSourceRepository.deleteById(newsSourceId);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/* This method should be used to update an existing newsSource. */
	
	@Override
	public NewsSource updateNewsSource(NewsSource newsSource, int newsSourceId) throws NewsSourceNotFoundException {
		final Optional<NewsSource> optionalNewsSource = newsSourceRepository.findById(newsSourceId);
		if(optionalNewsSource.isEmpty()) {
			throw new NewsSourceNotFoundException("news source not found");
		}
		newsSourceRepository.save(newsSource);
		return newsSource;
	}

	/* This method should be used to get a specific newsSource for an user. */

	@Override
	public NewsSource getNewsSourceById(String userId, int newsSourceId) throws NewsSourceNotFoundException {
		try {
			final List<NewsSource> newsSourceList = newsSourceRepository.findAllNewsSourceByNewsSourceCreatedBy(userId);
			for(NewsSource newsSource : newsSourceList) {
				if(newsSource.getNewsSourceId() == newsSourceId)
					return newsSource;
			}
		}
		catch (Exception e) {
			return null;
		}
		throw new NewsSourceNotFoundException("news source not found");
	}

	
	 /* This method should be used to get all newsSource for a specific userId.*/

	@Override
	public List<NewsSource> getAllNewsSourceByUserId(String createdBy) {
		final List<NewsSource> newsSourceList = newsSourceRepository.findAllNewsSourceByNewsSourceCreatedBy(createdBy);
		if(newsSourceList != null) {
			return newsSourceList;
		}
		return null;
	}

}
