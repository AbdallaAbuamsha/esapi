package com.example.esapi.service;

import com.example.esapi.entity.Section;
import com.example.esapi.entity.Tag;
import com.example.esapi.entity.User;
import com.example.esapi.repository.SectionRepository;
import com.example.esapi.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> get() {
        List<Section> sections = new ArrayList<>();
        sectionRepository.findAll().forEach(sections::add);
        return sections;
    }

    public Section get(long id) {
        return sectionRepository.findById(id).orElse(null);
    }

    public void save(Section section) {
        sectionRepository.save(section);
    }

    public List<Section> getSectionsByUserId(User user) {
        return sectionRepository.findByUsersId(user.getId());
    }
}
