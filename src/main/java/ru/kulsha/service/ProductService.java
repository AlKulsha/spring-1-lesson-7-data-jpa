package ru.kulsha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kulsha.model.Product;
import ru.kulsha.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> getProductByTitle(String title) {
        return productRepository.findAllByTitleContainingIgnoreCase(title);
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

}
