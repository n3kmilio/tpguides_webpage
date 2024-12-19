package tpguides.model;

import jakarta.persistence.*;

@Entity
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String game;
    private String title;

    @Lob
    private String content;


    public Guide() {}

    public Guide(String title, String content, String game) {
        this.title = title;
        this.content = content;
        this.game = game;

    }

    // Getter und Setter
}
