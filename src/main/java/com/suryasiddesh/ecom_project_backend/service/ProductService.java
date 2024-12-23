package com.suryasiddesh.ecom_project_backend.service;

import com.suryasiddesh.ecom_project_backend.model.Product;
import com.suryasiddesh.ecom_project_backend.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public Product getProductById(int prodId) {
        return repo.findById(prodId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + prodId));
    }

    public List<Product> getAllProducts()
    {
        return repo.findAll();
    }

    public Product updateProduct(Product product)
    {
        return repo.save(product);
    }

    public Optional<Product> deleteProduct(int prodId)
    {
        Optional<Product> prod1=repo.findById(prodId);
         repo.deleteById(prodId);
         return prod1;
    }


    public Product addProduct(Product product, MultipartFile imageFile)
    {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        try {
            product.setImageData(imageFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return repo.save(product);
    }



}
