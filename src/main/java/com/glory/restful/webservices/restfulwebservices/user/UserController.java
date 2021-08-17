package com.glory.restful.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final PostRepository postRepository;

    public UserController(UserService userService, PostRepository postRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public List<User> retrieveAllUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        return userService.findUser(id);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> retrievePost(@PathVariable Integer id) {
        return userService.findUser(id).getPosts();
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable Integer id, @RequestBody Post post) {
        Post savedPost = userService.savePost(id, post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
