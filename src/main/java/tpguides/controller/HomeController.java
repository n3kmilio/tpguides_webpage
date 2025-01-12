package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import tpguides.model.Guide;
import tpguides.repository.GuideRepository;
import tpguides.repository.UserRepository;
import tpguides.service.CustomUserDetailsService;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
     @Autowired
     UserRepository userRepository;
     @Autowired
     GuideRepository guideRepository;

    @GetMapping("/")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getName())) {
            model.addAttribute("isAuthenticated", true);
        } else {
            model.addAttribute("isAuthenticated", false);
        }

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
            Optional<tpguides.model.User> UserTP = userRepository.findByUsername(user.getUsername());
            String description = UserTP.get().getDescription();

            List<Guide> guides = guideRepository.findByAuthor(user.getUsername());

            model.addAttribute("username", user.getUsername());
            model.addAttribute("description", description);
            model.addAttribute("Guides", guides);
        } else {
            model.addAttribute("username", "Guest");
        }

        return "myprofile";
    }




    @GetMapping("/guide/{id}")
    public String guideDetails(@PathVariable Integer id, Model model) {
        Optional<Guide> guideOptional = guideRepository.findById(id);

        if (guideOptional.isPresent()) {
            Guide guide = guideOptional.get();
            model.addAttribute("guideTitle", guide.getTitle());
            model.addAttribute("guideDescription", guide.getDescription());
            model.addAttribute("guideContent", guide.getcontent());
        } else {
            model.addAttribute("errorMessage", "Guide not found");
        }
        return "guideDetails";
    }

    @GetMapping("/author-guides")
    public String getGuidesByAuthor(@RequestParam String author, Model model) {
        // Suche alle Guides für den angegebenen Autor
        List<Guide> guides = guideRepository.findByAuthor(author);

        if (guides.isEmpty()) {
            model.addAttribute("errorMessage", "No guides found for this author.");
        } else {
            model.addAttribute("guides", guides); // Liste der Guides
        }

        model.addAttribute("author", author); // Autor anzeigen
        return "authorGuides"; // Zeigt die entsprechende View an
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
