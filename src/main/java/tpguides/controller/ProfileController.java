package tpguides.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping("/myprofile")
    public String myprofile() {
        return "profile";  // This will resolve to src/main/resources/templates/profile.html
    }


    @GetMapping("/profile/details")
    public String getMyProfile(Authentication authentication, Model model) {
        return "This is profile details";
    }
}
