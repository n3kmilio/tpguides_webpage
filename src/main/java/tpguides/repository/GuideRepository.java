package tpguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tpguides.model.Guide;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Integer> {
    List<Guide> findByTitleContainingOrDescriptionContaining(String title, String description);
    Optional<Guide> findById(Integer id);
}