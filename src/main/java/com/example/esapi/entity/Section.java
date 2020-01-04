package com.example.esapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Length(min = 3, max = 127)
    @Column(nullable = false, unique = true, length = 127)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "sections")
    @JsonBackReference
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Product> Products;

    public Section() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Product> getProducts() {
        return Products;
    }

    public void setProducts(Set<Product> products) {
        Products = products;
    }
}
