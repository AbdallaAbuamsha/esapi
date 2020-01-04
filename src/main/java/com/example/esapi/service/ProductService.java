package com.example.esapi.service;

import com.example.esapi.entity.Product;
import com.example.esapi.entity.Section;
import com.example.esapi.entity.Tag;
import com.example.esapi.entity.User;
import com.example.esapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> get() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product get(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> getByUserId(long userId) {
        return productRepository.findByUserId(userId);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getBySectionId(long section) {
        return productRepository.findBySectionId(section);
    }

    public List<Product> getByTagId(long tag) {
        return productRepository.findByTagsId(tag);
    }

    public void addTag(Product product, Tag tag) {
        product.getTags().add(tag);
        tag.getProducts().add(product);

        productRepository.save(product);
    }
}
