package com.glory.restful.webservices.restfulwebservices.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @Past
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
