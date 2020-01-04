package com.example.esapi.repository;

import com.example.esapi.entity.Section;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SectionRepository extends CrudRepository<Section, Long> {
    List<Section> findByUsersId(long id);
}
