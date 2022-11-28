package ru.kulsha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kulsha.model.Product;
import ru.kulsha.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow();
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        Iterable<Product> products = productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        for (Product p : products) {
            productList.add(p);
        }
        return productList;
    }

    @GetMapping
    public List<Product> getProductByTitle(@RequestParam String title) {
        return productRepository.findAllByTitleContainingIgnoreCase(title);
    }
}
