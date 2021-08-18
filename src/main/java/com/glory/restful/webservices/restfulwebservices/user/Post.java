package com.glory.restful.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    private LocalDate posted;
    @JsonIgnore
    @ManyToOne
    private User user;

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
        this.posted = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", posted=" + posted +
                '}';
    }
}
