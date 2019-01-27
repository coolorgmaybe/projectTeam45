package com.javathon.projectTeam45.services;

import com.javathon.projectTeam45.entity.User;
import com.javathon.projectTeam45.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.javathon.projectTeam45.repos.UserRepo;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<Integer> list = new ArrayList<>();

        return user;
    }

    public User findByUsername(String filter) {
        return userRepo.findByUsername(filter);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public boolean addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);
        return true;
    }

    public void saveUser(User user, Map<String, String> form, String username) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String role : form.keySet()) {
            if(roles.contains(role)) {
                user.getRoles().add(Role.valueOf(role));
            }
        }
        userRepo.save(user);
    }

    public void updateProfile(User user, String password) {
        if(!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }
        userRepo.save(user);
    }
}
