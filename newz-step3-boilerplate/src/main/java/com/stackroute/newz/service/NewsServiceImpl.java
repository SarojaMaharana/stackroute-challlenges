package com.stackroute.newz.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.News;
import com.stackroute.newz.repository.NewsRepository;
import com.stackroute.newz.service.NewsService;
import com.stackroute.newz.util.exception.NewsAlreadyExistsException;
import com.stackroute.newz.util.exception.NewsNotExistsException;

import javax.transaction.Transactional;


/*
 * This class is implementing the NewsService interface. This class has to be annotated with 
 * @Service annotation.
 * @Service - is an annotation that annotates classes at the service layer, thus 
 * clarifying it's role.
 * 
 * */

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

	private NewsRepository newsRepository;

	/*
	 * Autowiring should be implemented for the NewsRepository.
	 */

	@Autowired
	public NewsServiceImpl(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	/*
	 * Add a new news. Throw NewsAlreadyExistsException if the news with specified
	 * newsId already exists.
	 */
	public News addNews(News news) throws NewsAlreadyExistsException {
		final News existingNews = newsRepository.getOne(news.getNewsId());
		if(existingNews != null) {
			throw new NewsAlreadyExistsException();
		}
		news.setPublishedAt(LocalDateTime.now());
		final News newNews = newsRepository.save(news);
		return newNews;
	}

	/*
	 * Retrieve an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public News getNews(int newsId) throws NewsNotExistsException {
		final Optional<News> newsOptional = newsRepository.findById(newsId);
		if(newsOptional.isEmpty()) {
			throw new NewsNotExistsException();
		}
		final News existingNews = newsOptional.get();
//		final News existingNews = newsRepository.getOne(newsId);
		return existingNews;
	}

	/*
	 * Retrieve all existing news
	 */
	public List<News> getAllNews() {
		return newsRepository.findAll();
	}

	
	/*
	 * Update an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public News updateNews(News news) throws NewsNotExistsException {
		final News newNews = newsRepository.getOne(news.getNewsId());
		if(newNews == null) {
			throw new NewsNotExistsException();
		}
		final News updatedNews = newsRepository.saveAndFlush(news);
		return updatedNews;
	}

	/*
	 * Delete an existing news by it's newsId. Throw NewsNotExistsException if the 
	 * news with specified newsId does not exist.
	 */
	public void deleteNews(int newsId) throws NewsNotExistsException {
		final News newNews = newsRepository.getOne(newsId);
		if(newNews == null) {
			throw new NewsNotExistsException();
		}
		newsRepository.deleteById(newsId);
	}

}
