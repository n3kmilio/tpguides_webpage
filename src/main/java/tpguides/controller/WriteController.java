package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tpguides.model.Guide;
import tpguides.repository.GuideRepository;

@Controller
public class WriteController {
    @Autowired
    private GuideRepository guideservice;

    public WriteController(GuideRepository guideRepository) {
        this.guideservice = guideRepository;
    }

    @PostMapping("/write")
    public String writeSubmit (@RequestParam("guide-input") String Content,
                               @RequestParam("title-input") String Title,
                               @RequestParam("desc-input")  String Desc,
                               @RequestParam("droppie")     String Game) {
        Guide guide = new Guide();
        guide.setContent(Content);
        guide.setGame(Game);
        guide.setDescription(Desc);
        guide.setTitle(Title);
        guideservice.save(guide);
        return "redirect:/";
    }
}