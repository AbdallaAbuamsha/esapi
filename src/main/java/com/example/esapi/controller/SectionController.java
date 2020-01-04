package com.example.esapi.controller;

import com.example.esapi.entity.Section;
import com.example.esapi.entity.User;
import com.example.esapi.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<Section>> get()
    {
        List<Section> sections = sectionService.get();
        return new ResponseEntity<>(sections, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Section> get(@PathVariable long id)
    {
        Section section = sectionService.get(id);
        return new ResponseEntity<>(section, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Section section)
    {
        sectionService.save(section);
        return new ResponseEntity<>(section, HttpStatus.CREATED);
    }
    @GetMapping("user/{user}")
    public ResponseEntity<List<Section>> subscribeSection(@PathVariable User user)
    {
        List<Section> result = sectionService.getSectionsByUserId(user);
        return new ResponseEntity<List<Section>>(result, HttpStatus.OK);
    }
}
