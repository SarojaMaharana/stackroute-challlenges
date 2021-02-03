package com.stackroute.newz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stackroute.newz.model.News;
import com.stackroute.newz.model.UserNews;
import com.stackroute.newz.repository.NewsRepository;
import com.stackroute.newz.repository.UserNewsRepository;
import com.stackroute.newz.util.exception.NewsNotFoundException;
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
public class NewsServiceImpl implements NewsService {

	private NewsRepository newsRepository;

	/*
	 * Autowiring should be implemented for the NewsRepository and MongoOperation.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */

	@Autowired
	public NewsServiceImpl(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	/*
	 * This method should be used to save a new news.
	 */
	@Override
	public boolean addNews(News news) {
		news.setPublishedAt();
		final Optional<UserNews> optionalUserNews = newsRepository.findById(news.getAuthor());
		if(optionalUserNews.isPresent()) {
			final UserNews userNews = optionalUserNews.get();
			// checking in the user's news list whether new news already exists
			if(userNews.getNewslist() != null) {
				for (News n : userNews.getNewslist()) {
					if (n.getNewsId() == news.getNewsId()) {
						return false;
					}
				}
				final List<News> newsList = userNews.getNewslist();
				newsList.add(news);
				userNews.setNewslist(newsList);
				return (newsRepository.insert(userNews) != null);
			} else { // if user is there but newsList is empty
				List<News> newNewsList = new ArrayList<>();
				newNewsList.add(news);
				userNews.setNewslist(newNewsList);
				return (newsRepository.insert(userNews) != null);
			}
		}
		else {
			final UserNews userNews = new UserNews();
			userNews.setUserId(news.getAuthor());
			final List<News> newNewsList = new ArrayList<>();
			newNewsList.add(news);
			userNews.setNewslist(newNewsList);
			return (newsRepository.insert(userNews) != null);
		}
	}

	/* This method should be used to delete an existing news. */
	
	public boolean deleteNews(String userId, int newsId) {
		Optional<UserNews> optionalUserNews = newsRepository.findById(userId);
		if(optionalUserNews.isPresent()){
			UserNews userNews = optionalUserNews.get();
			List<News> newsList = userNews.getNewslist();
			boolean flag = false;

			for (News n : newsList) {
				if (n.getNewsId() == newsId) {
					newsList.remove(n);
					flag = true;
					break;
				}
			}
			if(flag) {
				userNews.setNewslist(newsList);
				newsRepository.save(userNews);
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	/* This method should be used to delete all news for a  specific userId. */
	
	public boolean deleteAllNews(String userId) throws NewsNotFoundException {
		try {
			final Optional<UserNews> optionalUserNews = newsRepository.findById(userId);
			if (optionalUserNews.isPresent()) {
				newsRepository.delete(optionalUserNews.get());
				return true;
			}
		} catch (Exception e) {
			throw new NewsNotFoundException("news not found");
		}
		return false;
	}

	/*
	 * This method should be used to update a existing news.
	 */

	public News updateNews(News news, int newsId, String userId) throws NewsNotFoundException {
		try {
			final UserNews userNews = newsRepository.findById(userId).get();
			List<News> newsList = userNews.getNewslist();
			boolean flag = false;

			for (News n : newsList) {
				if (n.getNewsId() == newsId) {
					news.setPublishedAt();
					newsList.set(newsList.indexOf(n), news);
					//				n = news;
					flag = true;
					break;
				}
			}

			if(flag) {
				userNews.setNewslist(newsList);
				newsRepository.save(userNews);
				return news;
			} else {
				throw new NewsNotFoundException("news not found");
			}
		} catch (Exception e) {
			throw new NewsNotFoundException("news not found");
		}
	}

	/*
	 * This method should be used to get a news by newsId created by specific user
	 */

	public News getNewsByNewsId(String userId, int newsId) throws NewsNotFoundException {
		try {
			final Optional<UserNews> optionalUserNews = newsRepository.findById(userId);
			if(optionalUserNews.isPresent()){
				final UserNews userNews = optionalUserNews.get();
				for (News n : userNews.getNewslist()) {
					if (n.getNewsId() == newsId){
						return n;
					}
				}
			}
			throw new NewsNotFoundException("news not found");
		} catch (Exception e) {
			throw new NewsNotFoundException("news not found");
		}
	}

	/*
	 * This method should be used to get all news for a specific userId.
	 */

	public List<News> getAllNewsByUserId(String userId) {
		return newsRepository.findById(userId).get().getNewslist();
	}

}
