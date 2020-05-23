package my.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LogInOutController {

    @GetMapping("/login")
    public String loginForm() {
        return "account/login";
    }

    @GetMapping("/logout")
    public String logoutForm() {
        return "account/logout";
    }

    @GetMapping("/access-denied")
    public String accessDenied(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        return "account/access-denied";
    }

}
