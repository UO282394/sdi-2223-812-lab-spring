package com.uniovi.notaineitor.entities;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Mark {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String description;
    private Double score;
    public Mark() {
    }

    public Mark(Long id, String description, Double score) {
        this.id = id;
        this.description = description;
        this.score = score;
    }
    public Mark(String description, Double score, User user) {
        super();
        this.user = user;
        this.description = description;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Mark{" + "id=" + id + ", description='" + description + '\'' + ", score=" + score + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return Objects.equals(id, mark.id);
    }
public User getUser(){
        return user;
}
public void setUser(User u){
        user = u;
}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {this.description = description;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
}