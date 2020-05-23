package my.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.user.model.Book;
import my.common.model.Page;
import my.user.service.BookService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = {"/book", "/book/{id}"}, method = RequestMethod.GET)
    public String book(Model model, @PathVariable(value = "id", required = false) String id) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "user/book";
    }

    @RequestMapping(value = {"/bookList", "/bookList/{currentPage}"}, method = RequestMethod.GET)
    public String bookList(Model model, @PathVariable(value = "currentPage", required = false) Optional<Integer> currentPage, String searchWord) {
        Book book = new Book();
        book.setSearchWord(searchWord);
        Page page = new Page(currentPage.orElse(1), 5);
        page.setTotalCount(bookService.getBookListTotalCount(book));
        book.setPage(page);

        List bookList = bookService.getBookList(book);
        model.addAttribute("bookList", bookList);
        model.addAttribute("page", page);
        return "user/bookList";
    }

    @RequestMapping(value = {"/bookUpdate", "/bookUpdate/{id}"}, method = RequestMethod.GET)
    public String bookUpdate(Model model, @PathVariable(value = "id", required = false) String id) {
        if(id != null) {
            Book book = bookService.getBook(id);
            model.addAttribute("book", book);
        }
        return "user/bookUpdate";
    }

    @PostMapping("/bookUpdate")
    public String bookUpdateProcess(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return "redirect:/book/" + book.getId();
    }

    @GetMapping("/bookWrite")
    public String bookWrite() {
        return "user/bookWrite";
    }

    @PostMapping("/bookWrite")
    public String bookWriteProcess(@ModelAttribute Book book) {
        bookService.writeBook(book);
        return "redirect:/book/" + book.getId();
    }

}