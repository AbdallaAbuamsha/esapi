package com.example.esapi.service;

import com.example.esapi.entity.Tag;
import com.example.esapi.entity.User;
import com.example.esapi.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> get() {
        List<Tag> tags = new ArrayList<>();
        tagRepository.findAll().forEach(tags::add);
        return tags;
    }

    public Tag get(long id) {
        return tagRepository.findById(id).orElse(null);
    }

    public void save(Tag tag) {
        tagRepository.save(tag);
    }
}
