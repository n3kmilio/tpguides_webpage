package tpguides.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpguides.model.Guide;
import tpguides.repository.GuideRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuideService {

    @Autowired
    private GuideRepository guideRepository;


    public List<Guide> searchGuides(String searchTerm, List<String> tags) {
        List<Guide> guides = guideRepository.findAll();

        return guides.stream()
                .filter(guide -> {
                    boolean matchesSearchTerm = guide.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                            guide.getDescription().toLowerCase().contains(searchTerm.toLowerCase());

                    boolean matchesTags = tags == null || tags.isEmpty() ||
                            tags.stream().allMatch(tag -> guide.getTags().stream().anyMatch(guideTag -> guideTag.toLowerCase().contains(tag.toLowerCase())));

                    return matchesSearchTerm && matchesTags;
                })
                .collect(Collectors.toList());
    }
}
