package com.glory.restful.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
