package com.informatics.practice.app.repository;

import com.informatics.practice.app.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
