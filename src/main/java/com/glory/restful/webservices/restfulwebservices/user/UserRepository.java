package com.glory.restful.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {
    private final static List<User> users = new ArrayList<>();
    private static int countUser = 3;

    static {
        users.add(new User(1, "Adam", LocalDate.of(1990, Month.AUGUST, 2)));
        users.add(new User(2, "Eve", LocalDate.of(1970, Month.JANUARY, 3)));
        users.add(new User(3, "Jack", LocalDate.of(1965, Month.AUGUST, 2)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) user.setId(++countUser);
        users.add(user);
        return user;
    }

    public User findOne(Integer id) {
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
        return userOptional.orElseThrow(() -> new UserNotFoundException("id: " + id));
    }

    public User deleteById(Integer id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return user;
            }
        }
        return null;
    }
}
