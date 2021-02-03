package com.stackroute.newz.service;

import com.stackroute.newz.model.NewsSource;
import com.stackroute.newz.util.exception.NewsSourceNotFoundException;

import java.util.List;

public interface NewsSourceService {

	boolean blockNewssource(String userId,String  newssourceId);
	
	
	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

	boolean addNewsSource(NewsSource newsSource);

	boolean deleteNewsSource(int newsSourceId);

	NewsSource updateNewsSource(NewsSource newsSource, int newsSourceId) throws NewsSourceNotFoundException;

	NewsSource getNewsSourceById(String userId,int newsSourceId) throws NewsSourceNotFoundException;

	List<NewsSource> getAllNewsSourceByUserId(String userId);

}
