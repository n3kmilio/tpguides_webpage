package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tpguides.model.Guide;
import tpguides.repository.GuideRepository;

@RestController
@RequestMapping("/api/write")
public class WriteController {

    @Autowired
    private GuideRepository guideservice;
    private Guide guide;

    public WriteController(GuideRepository guideRepository) {
        this.guide = new Guide();
        this.guideservice = guideRepository;
    }

    @PostMapping(value = "/search", consumes = "application/json")
    public String getGame(@RequestBody String json) {
        guide.setGame(json);
        return "redirect:/";
    }

    @PostMapping("/write")
    public String writeSubmit (@RequestParam("guide-input") String Content,
                               @RequestParam("title-input") String Title,
                               @RequestParam("desc-input")  String Desc) {
        guide.setContent(Content);
        guide.setDescription(Desc);
        guide.setTitle(Title);
        guideservice.save(guide);
        return "redirect:/";
    }
}