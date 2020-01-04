package com.example.esapi.repository;

import com.example.esapi.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>
{

    List<Product> findByUserId(long userId);

    List<Product> findBySectionId(long section);

    List<Product> findByTagsId(long tag);

}
