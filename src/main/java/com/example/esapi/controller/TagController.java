package com.example.esapi.controller;

import com.example.esapi.entity.Tag;
import com.example.esapi.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> get()
    {
        List<Tag> tags = tagService.get();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tag> get(@PathVariable long id)
    {
        Tag tag = tagService.get(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Tag tag)
    {
        tagService.save(tag);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }
}
