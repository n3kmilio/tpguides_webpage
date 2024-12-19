package tpguides.model;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        if (this.name.isEmpty()) return this.name.isEmpty();

        else return false;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
// Getter und Setter...
}
