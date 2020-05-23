package my.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import my.user.mapper.BlogMapper;
import my.user.model.Blog;

import java.util.List;

@Slf4j
@Service
@Transactional
public class BlogService {

    @Autowired
    BlogMapper blogMapper;

    public Blog getBlog(String id) {
        return blogMapper.selectBlog(id);
    }

    public List getBlogList(Blog blog) {
        return blogMapper.selectBlogList(blog);
    }

    public List getBlogViewList(String id) {
        return blogMapper.selectBlogViewList(id);
    }

    public int getBlogListTotalCount(Blog blog) {
        return blogMapper.selectBlogListTotalCount(blog);
    }

    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    public int writeBlog(Blog blog) {
        return blogMapper.insertBlog(blog);
    }

}