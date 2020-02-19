package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class Category {
     @Id
    private String id;
    private String nom;
    @DBRef
    private Collection<Product> products=new ArrayList<>();


    public Category(String id,String nom, Collection<Product> products) {
        this.nom = nom;
        this.products = products;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
