package my.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.admin.model.Stats;
import my.admin.service.StatsService;
import my.common.model.Page;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class StatsController {

    @Autowired
    StatsService statsService;

    @RequestMapping(value = {"/statsList", "/statsList/{currentPage}"}, method = RequestMethod.GET)
    public String statsList(Model model, @PathVariable(value = "currentPage", required = false) Optional<Integer> currentPage, String searchWord) {
        Stats stats = new Stats();
        stats.setSearchWord(searchWord);
        Page page = new Page(currentPage.orElse(1), 10);
        page.setTotalCount(statsService.getStatsLoginListTotalCount(stats));
        stats.setPage(page);

        List statsList = statsService.getStatsLoginList(stats);
        model.addAttribute("statsList", statsList);
        model.addAttribute("page", page);
        return "admin/statsList";
    }

}
