package tpguides.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private String User;
    private String Guide;

    public Long getId() { return id; }

    public String getComment() { return comment;}

    public String getUser() { return User;}

    public String getGuide() { return Guide;}

    public void setId(Long id) {this.id = id;}

    public void setComment(String comment) { this.comment = comment;}

    public void setUser(String User) { this.User = User;}

    public void setGuide(String Guide) { this.Guide = Guide;}
}
