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

    @GetMapping("/")
    public String showForm() {
        return "form";
    }
    @PostMapping("/publish")
    public String writeSubmit (@RequestParam("content") String Content) {
        Guide guide = new Guide();
        guide.setContent(Content);
        guideservice.save(guide);
        return "redirect:/";
    }

}