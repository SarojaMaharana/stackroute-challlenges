package com.stackroute.defaultmethods.service;


import com.stackroute.defaultmethods.domain.Blog;


public interface BlogAuthoringService {
    String[] informalWords = {"chill", "dude", "crap", "crazy"};

    String publishBlog(Blog blog);

    /* Create the default method to reject the blog content with informal words,empty and blank blog content */
    default boolean rejectBlogForInformalWords(Blog blog){
        String temp = blog.getBlogContent();
        if(temp.equalsIgnoreCase("") || temp.equalsIgnoreCase(" "))
            return true;
        temp = temp.replaceAll("[^A-Za-z0-9]", " ").toLowerCase();
        String[] tempArr = temp.split(" ");
        boolean toReturn = false;

        for(String s:tempArr){
            for(String s2:informalWords){
                if(s.equalsIgnoreCase(s2)){
                    toReturn = true;
                    break;
                }
                else
                    continue;
            }
        }
        return toReturn;
    }

}