package ru.kulsha.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "products")
public class Product {

    public Product() {
    }

    public Product(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;
}
