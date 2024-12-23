package com.suryasiddesh.ecom_project_backend.controller;

import com.suryasiddesh.ecom_project_backend.model.Product;
import com.suryasiddesh.ecom_project_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController

public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/products/{id}")
    public Product getProdById(@PathVariable Long id) {
        return service.getProductById(id);
    }


    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @RequestMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
    {
        return service.addProduct(product);
    }

}
