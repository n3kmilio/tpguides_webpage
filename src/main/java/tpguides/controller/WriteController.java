package tpguides.controller;

import jakarta.persistence.criteria.Selection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tpguides.model.Guide;
import tpguides.repository.GuideRepository;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(method={RequestMethod.POST},value = "/dropdownButto")
public class WriteController {
    @Autowired
    private GuideRepository guideservice;

    public WriteController(GuideRepository guideRepository) {
        this.guideservice = guideRepository;
    }

    @PostMapping("/write")
    public @ResponseBody String writeSubmit (@RequestParam("guide-input") String Content,
                               @RequestParam("title-input") String Title,
                               @RequestParam("desc-input")  String Desc,
                               @RequestBody String Game) {
        Guide guide = new Guide();
        guide.setContent(Content);
        guide.setDescription(Desc);
        guide.setTitle(Title);
        guide.setGame(String.valueOf(Game));
        guideservice.save(guide);
        return "redirect:/";
    }
}


