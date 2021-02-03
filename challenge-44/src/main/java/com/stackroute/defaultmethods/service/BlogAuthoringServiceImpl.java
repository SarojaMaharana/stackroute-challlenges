package com.stackroute.defaultmethods.service;

import com.stackroute.defaultmethods.domain.Blog;

public class BlogAuthoringServiceImpl implements BlogAuthoringService {

    /* Override this method to return a string message */
    public String publishBlog(Blog blog) {
        String toReturn = processBlog(blog);
        return toReturn;
    }

    /* Write the logic for processing the blog */
    public String processBlog(Blog blog) {
        boolean haveInformal = rejectBlogForInformalWords(blog);
        String toReturn = "";

        if(haveInformal)
            toReturn = "Blog is rejected!";
        else
            toReturn = "Blog published successfully";

        return toReturn;
    }

}
