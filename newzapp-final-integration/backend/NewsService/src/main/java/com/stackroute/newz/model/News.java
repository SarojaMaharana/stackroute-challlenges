package com.stackroute.newz.model;

import java.time.LocalDateTime;

public class News {

	
	/*
	 * This class should have ten fields
	 * (newsId,title,author,description,publishedAt,content,url,urlToImage,Reminder,
	 * NewsSource). This class should also contain the getters and setters for the 
	 * fields along with the no-arg , parameterized	constructor and toString method.
	 * The value of publishedAt should not be accepted from the user but should be
	 * always initialized with the system date.
	 */

	private int newsId;
	private String title;
	private String author;
	private String description;
	private LocalDateTime publishedAt;
	private String content;
	private String url;
	private String urlToImage;
	private Reminder reminder;
	private NewsSource newsSource;

	public News() {
	}

	public News(int newsId, String title, String author, String description, LocalDateTime publishedAt, String content, String url, String urlToImage, Reminder reminder, NewsSource newsSource) {
		this.newsId = newsId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.publishedAt = publishedAt;
		this.content = content;
		this.url = url;
		this.urlToImage = urlToImage;
		this.reminder = reminder;
		this.newsSource = newsSource;
	}

	public Reminder getReminder() {
		return reminder;
	}

	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt() {
		this.publishedAt = LocalDateTime.now();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public NewsSource getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(NewsSource newsSource) {
		this.newsSource = newsSource;
	}

	@Override
	public String toString() {
		return "News{" +
				"newsId=" + newsId +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", description='" + description + '\'' +
				", publishedAt=" + publishedAt +
				", content='" + content + '\'' +
				", url='" + url + '\'' +
				", urlToImage='" + urlToImage + '\'' +
				", reminder=" + reminder +
				", newsSource=" + newsSource +
				'}';
	}
}
