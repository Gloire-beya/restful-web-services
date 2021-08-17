package com.glory.restful.webservices.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new UserNotFoundException("id: " + id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        }else {
            throw new UserNotFoundException("ID: "+ id);
        }
    }
    public Post savePost(Integer id, Post post){
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) throw new UserNotFoundException("ID :" + id);
        User user = optionalUser.get();
        post.setUser(user);
        return postRepository.save(post);
    }
}
