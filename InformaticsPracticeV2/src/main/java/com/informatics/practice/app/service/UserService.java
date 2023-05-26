package com.informatics.practice.app.service;
import com.informatics.practice.app.entity.User;
import com.informatics.practice.app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user!=null){
            return user;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public void saveToken(String username, String token) {
        User user = userRepo.findByUsername(username);
        user.setToken(token);
        userRepo.save(user);
    }
}
