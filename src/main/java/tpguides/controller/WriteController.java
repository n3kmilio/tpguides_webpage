package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tpguides.model.Guide;
import tpguides.repository.GuideRepository;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class WriteController {
    @Autowired
    private GuideRepository guideservice;
    private String game;


    @RequestMapping(value = "resources/static/Javascript/dropdown.js/{gameName}", method = GET)
    public String getGame(@PathVariable("gameName") String game1){ return this.game = game1; }

    public WriteController(GuideRepository guideRepository) {
        this.guideservice = guideRepository;
    }
    @PostMapping("/write")
    public String writeSubmit (@RequestParam("guide-input") String Content,
                               @RequestParam("title-input") String Title,
                               @RequestParam("desc-input")  String Desc) {
        Guide guide = new Guide();
        guide.setContent(Content);
        guide.setDescription(Desc);
        guide.setTitle(Title);
        guide.setGame(game);
        guideservice.save(guide);
        return "redirect:/";
    }
}