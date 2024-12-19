package tpguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tpguides.model.Guide;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {
    List<Guide> findByTitleContainingOrDescriptionContaining(String title, String description);
}