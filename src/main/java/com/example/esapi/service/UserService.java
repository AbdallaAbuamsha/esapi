package com.example.esapi.service;

import com.example.esapi.entity.Section;
import com.example.esapi.entity.User;
import com.example.esapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> get() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User get(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public void subscribeSection(User user, Section section) {
        user.getSections().add(section);
        section.getUsers().add(user);
        userRepository.save(user);
    }

    public List<User> getUsersBySectionId(Section section) {
        return userRepository.findBySectionsId(section.getId());
    }
}
