package ru.kulsha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.kulsha.model.Product;
import ru.kulsha.repository.ProductRepository;

import java.awt.desktop.AppReopenedEvent;

@Component
public class DatabaseInit {

    @Autowired
    ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void databaseInit(){
        productRepository.save(createProduct("book", 1250));
        productRepository.save(createProduct("ball", 2300));
        productRepository.save(createProduct("doll", 2600));
        productRepository.save(createProduct("bear", 750));
        productRepository.save(createProduct("pencil", 80));
        productRepository.save(createProduct("candy", 20));

    }

    private Product createProduct(String title, int price){
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        return product;
    }
}
