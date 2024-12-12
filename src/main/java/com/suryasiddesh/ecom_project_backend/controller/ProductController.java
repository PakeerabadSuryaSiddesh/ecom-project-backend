package com.suryasiddesh.ecom_project_backend.controller;

import com.suryasiddesh.ecom_project_backend.model.Product;
import com.suryasiddesh.ecom_project_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/ProductById/{id}")
    public Product getProdById(@RequestBody int prodId) {
        return service.getProductById(prodId);
    }

    @RequestMapping("/allProducts")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
}
