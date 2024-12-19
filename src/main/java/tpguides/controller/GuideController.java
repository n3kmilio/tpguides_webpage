package tpguides.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpguides.model.Guide;
import tpguides.repository.GuideRepository;

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
}
