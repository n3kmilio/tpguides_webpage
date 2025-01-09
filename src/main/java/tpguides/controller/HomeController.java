package tpguides.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/link")
    public String link() {
        return "link";
    }

    @GetMapping("/myprofile")
    public String myprofile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof User) {
            User user = (User) principal;
            model.addAttribute("username", user.getUsername());
        } else {
            // Handle other types or fallback if necessary
            model.addAttribute("username", "Guest");
        }

        return "myprofile";
    }

    @GetMapping("/guide")
    public String guide() {
        return "guide";
    }

    @GetMapping("/results")
    public String results() {
        return "results";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

}
