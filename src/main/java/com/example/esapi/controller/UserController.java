package com.example.esapi.controller;

import com.example.esapi.entity.Section;
import com.example.esapi.entity.User;
import com.example.esapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> get()
    {
        List<User> users = userService.get();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable long id)
    {
        User user = userService.get(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user)
    {
        userService.save(user);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id)
    {
        userService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // Lather this will be list of sections to add
    @PostMapping("{user}/subscribeSection/{section}")
    public ResponseEntity<?> subscribeSection(@PathVariable User user, @PathVariable Section section)
    {
        userService.subscribeSection(user, section);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("section/{section}")
    public ResponseEntity<List<User>> subscribeSection(@PathVariable Section section)
    {
        List<User> result = userService.getUsersBySectionId(section);
        return new ResponseEntity<List<User>>(result, HttpStatus.OK);
    }
}
