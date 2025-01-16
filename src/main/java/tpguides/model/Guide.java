package tpguides.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String title;
    private String description;
    private String author;
    private String content;
    private String game;
    //protected Set<Comment> comments;

    @ElementCollection
    private List<String> tags = new ArrayList<>();

    public String getGame() {
        return game;
    }

    //public Set<Comment> getComment() {return comments;}

    //public void setComment(Set<Comment> comment) { this.comments = comment;}

    public void setGame(String game) {
        this.game = game;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getcontent(){ return content; }

    public void setContent(String content) { this.content = content; }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
