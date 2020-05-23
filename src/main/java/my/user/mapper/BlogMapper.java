package my.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import my.user.model.Blog;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {

    Blog selectBlog(String id);

    List selectBlogList(Blog blog);

    List selectBlogViewList(String id);

    int selectBlogListTotalCount(Blog blog);

    int updateBlog(Blog blog);

    int insertBlog(Blog blog);

}
