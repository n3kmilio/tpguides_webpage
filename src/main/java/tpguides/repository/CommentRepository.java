package tpguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tpguides.model.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
