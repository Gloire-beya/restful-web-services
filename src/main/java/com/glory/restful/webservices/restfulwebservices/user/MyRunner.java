package com.glory.restful.webservices.restfulwebservices.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public MyRunner(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) {

        User jane = new User("Jane", "Kabwe","janekabwe@gmail.com",LocalDate.of(2000, Month.AUGUST, 1));
        User fatu = new User("Fatu", "Mwinga","fatumamwinga@gmail.com",LocalDate.of(1990, Month.FEBRUARY, 4));
        userRepository.saveAll(List.of(jane, fatu));

        Post post1 = new Post("Jane's first post", jane);
        Post post2 = new Post("Jane's second post", jane);
        Post post3 = new Post("Fatu's first post", fatu);
        postRepository.saveAll(List.of(post1, post2, post3));
    }
}
