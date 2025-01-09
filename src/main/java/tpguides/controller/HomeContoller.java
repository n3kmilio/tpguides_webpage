package tpguides.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {

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
    public String myprofile() {
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
