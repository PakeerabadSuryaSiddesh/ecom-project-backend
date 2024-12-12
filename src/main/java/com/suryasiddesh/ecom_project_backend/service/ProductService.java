package com.suryasiddesh.ecom_project_backend.service;

import com.suryasiddesh.ecom_project_backend.model.Product;
import com.suryasiddesh.ecom_project_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public Product getProductById(int prodId)
    {
        return repo.getById(prodId);

    }

    public List<Product> getAllProducts()
    {
        return repo.findAll();
    }
}
