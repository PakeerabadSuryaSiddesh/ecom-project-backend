package com.suryasiddesh.ecom_project_backend.service;

import com.suryasiddesh.ecom_project_backend.model.Product;
import com.suryasiddesh.ecom_project_backend.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public Product getProductById(Long prodId) {
        return repo.findById(prodId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + prodId));
    }

    public List<Product> getAllProducts()
    {
        return repo.findAll();
    }

    public Product addProduct(Product product)
    {
        return repo.save(product);
    }

}
