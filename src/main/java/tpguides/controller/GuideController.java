package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model; // Importiere das Spring Model hier
import org.springframework.web.bind.annotation.*;
import tpguides.model.Guide;
import tpguides.repository.GuideRepository;
import tpguides.service.GuideService;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
public class GuideController {

    private final GuideRepository guideRepository;

    public GuideController(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    @GetMapping
    public List<Guide> getAllGuides() {
        return guideRepository.findAll();
    }

    @GetMapping("/guide/{id}")
    public String getGuide(@PathVariable Long id, Model model) {
        Guide guide = guideRepository.findById(id).orElseThrow(() -> new RuntimeException("Guide not found"));
        model.addAttribute("guide", guide);
        return "guide"; // render guide.html
    }

    @GetMapping("/search")
    public List<Guide> searchGuides(@RequestParam(required = false) String searchTerm) {
        if (searchTerm != null && !searchTerm.isEmpty()) {
            return guideRepository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
        }
        return guideRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Guide> createGuide(@RequestBody Guide guide) {
        Guide savedGuide = guideRepository.save(guide);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGuide);
    }

    @Autowired
    private GuideService guideService;

    @GetMapping("/results")
    public String showSearchResults(@RequestParam(name = "searchTerm", required = false, defaultValue = "") String searchTerm,
                                    @RequestParam(name = "tags", required = false) List<String> tags,
                                    Model model) {

        // Suche nach den Guides anhand des Suchbegriffs und der Tags
        model.addAttribute("guides", guideService.searchGuides(searchTerm, tags));
        model.addAttribute("searchTerm", searchTerm);
        return "result"; // result.html wird gerendert
    }

}
