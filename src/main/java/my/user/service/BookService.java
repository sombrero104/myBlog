package my.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import my.user.mapper.BookMapper;
import my.user.model.Book;

import java.util.List;

@Slf4j
@Service
@Transactional
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public Book getBook(String id) {
        return bookMapper.selectBook(id);
    }

    public int getBookListTotalCount(Book book) {
        return bookMapper.selectBookListTotalCount(book);
    }

    public List getBookList(Book book) {
        return bookMapper.selectBookList(book);
    }

    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    public int writeBook(Book book) {
        return bookMapper.insertBook(book);
    }

}