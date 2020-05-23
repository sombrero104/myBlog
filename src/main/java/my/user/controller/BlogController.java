package my.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.user.model.Blog;
import my.common.model.Page;
import my.user.service.BlogService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping(value = {"/blog", "/blog/{id}"}, method = RequestMethod.GET)
    public String blog(Model model, @PathVariable(value = "id", required = false) String id) {
        Blog blog = blogService.getBlog(id);
        List blogList = blogService.getBlogViewList(id);
        model.addAttribute("blog", blog);
        model.addAttribute("blogList", blogList);
        return "user/blog";
    }

    @RequestMapping(value = {"/blogList", "/blogList/{currentPage}"}, method = RequestMethod.GET)
    public String blogList(Model model, @PathVariable(value = "currentPage", required = false) Optional<Integer> currentPage, String searchWord) {
        Blog blog = new Blog();
        blog.setSearchWord(searchWord);
        Page page = new Page(currentPage.orElse(1), 10);
        page.setTotalCount(blogService.getBlogListTotalCount(blog));
        blog.setPage(page);

        List blogList = blogService.getBlogList(blog);
        model.addAttribute("blogList", blogList);
        model.addAttribute("page", page);
        return "user/blogList";
    }

    @RequestMapping(value = {"/blogUpdate", "/blogUpdate/{id}"}, method = RequestMethod.GET)
    public String blogUpdate(Model model, @PathVariable(value = "id", required = false) String id) {
        if(id != null) {
            Blog blog = blogService.getBlog(id);
            model.addAttribute("blog", blog);
        }
        return "user/blogUpdate";
    }

    @PostMapping("/blogUpdate")
    public String blogUpdateProcess(@ModelAttribute Blog blog) {
        blogService.updateBlog(blog);
        return "redirect:/blog/" + blog.getId();
    }

    @GetMapping("/blogWrite")
    public String blogWrite() {
        return "user/blogWrite";
    }

    @PostMapping("/blogWrite")
    public String blogWriteProcess(@ModelAttribute Blog blog) {
        blogService.writeBlog(blog);
        return "redirect:/blog/" + blog.getId();
    }

}
