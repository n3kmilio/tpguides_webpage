package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tpguides.model.Guide;
import tpguides.repository.GuideRepository;

@Controller
public class WriteController {
    @Autowired
    private GuideRepository guideservice;


    @PostMapping("/submit")
    public String writeSubmit (@RequestParam("guide-input") String Content,
                               @RequestParam("title-input") String Title,
                               @RequestParam("dropdownConten") String game) {
        Guide guide = new Guide();
        guide.setContent(Content);
        guide.setTitle(Title);
        guide.setGame(game);
        guideservice.save(guide);
        return "redirect:/";
    }

}