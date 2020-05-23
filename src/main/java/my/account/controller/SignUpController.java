package my.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import my.account.model.Account;
import my.account.service.AccountService;

@Controller
public class SignUpController {

    @Autowired
    AccountService accountService;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("account", new Account());
        return "account/signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute Account account) {
        account.setRole("USER");
        accountService.createNewAccount(account);
        return "redirect:/";
    }

}
