package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.exception.BlogAlreadyExistsException;
import com.stackroute.exception.BlogNotFoundException;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) throws BlogAlreadyExistsException {
        if(blogRepository.existsById(blog.getBlogId())) {
            throw new BlogAlreadyExistsException();
        }
        final Blog savedBlog = blogRepository.save(blog);
        return savedBlog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) throws BlogNotFoundException {
        final Optional<Blog> optionalBlog =blogRepository.findById(id);
        if(optionalBlog.isEmpty()) {
            throw new BlogNotFoundException();
        }
        return optionalBlog.get();
    }

    @Override
    public Blog deleteBlog(int id) throws BlogNotFoundException {
        final Optional<Blog> optionalBlog =blogRepository.findById(id);
        if(optionalBlog.isPresent()) {
            blogRepository.findById(id);
            blogRepository.deleteById(id);
            return optionalBlog.get();
        }
        throw new BlogNotFoundException();
    }

    @Override
    public Blog updateBlog(Blog blog) throws BlogNotFoundException {
        final Optional<Blog> optionalBlog =blogRepository.findById(blog.getBlogId());
        if(optionalBlog.isPresent()) {
            final Blog updatedBlog = blogRepository.save(blog);
            return blogRepository.findById(blog.getBlogId()).get();
        }
        throw new BlogNotFoundException();
    }
}
