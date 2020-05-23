package my.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import my.user.model.Book;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    Book selectBook(String id);

    int selectBookListTotalCount(Book book);

    List selectBookList(Book book);

    int updateBook(Book book);

    int insertBook(Book book);

}
