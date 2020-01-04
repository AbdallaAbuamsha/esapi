package com.example.esapi.controller;

import com.example.esapi.entity.Product;
import com.example.esapi.entity.Section;
import com.example.esapi.entity.Tag;
import com.example.esapi.entity.User;
import com.example.esapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> get()
    {
        List<Product> product = productService.get();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable long id)
    {
        Product product = productService.get(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product)
    {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Product>> getByUserId(@PathVariable long userId)
    {
        return new ResponseEntity<List<Product>> (productService.getByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id)
    {
        productService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/section/{section}")
    public ResponseEntity<List<Product>> getBySectionId(@PathVariable long section)
    {
        List<Product> result = productService.getBySectionId(section);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("tag/{tagId}")
    public ResponseEntity<List<Product>> getByTagId(@PathVariable long tagId)
    {
        List<Product> result = productService.getByTagId(tagId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // Lather this will be list of tags to add
    @PostMapping("{product}/addTag/{tag}")
    public ResponseEntity<?> subscribeSection(@PathVariable Product product, @PathVariable Tag tag)
    {
        productService.addTag(product, tag);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
