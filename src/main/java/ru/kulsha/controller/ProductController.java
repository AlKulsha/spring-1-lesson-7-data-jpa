package ru.kulsha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kulsha.exceptions.AppError;
import ru.kulsha.model.Product;
import ru.kulsha.repository.ProductRepository;
import ru.kulsha.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/all")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{title}")
    public List<Product> getProductByTitle(@RequestParam String title) {
        return productService.getProductByTitle(title);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping("/new")
    public void createNewProduct(@RequestParam String title){
        productService.save(new Product(title));
    }


}
