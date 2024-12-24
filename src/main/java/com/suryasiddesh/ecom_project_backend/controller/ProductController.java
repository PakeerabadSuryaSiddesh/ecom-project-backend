package com.suryasiddesh.ecom_project_backend.controller;

import com.suryasiddesh.ecom_project_backend.model.Product;
import com.suryasiddesh.ecom_project_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProdById(@PathVariable int id) {
        return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
    }

    @RequestMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product)
    {
        return new ResponseEntity<>( service.updateProduct(product),HttpStatus.OK);
    }

    @RequestMapping("/deleteProduct/{prodId}")
    public ResponseEntity<Optional<Product>> deleteProduct(@PathVariable int prodId)
    {
        return new ResponseEntity<>(service.deleteProduct(prodId),HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addproduct(@RequestPart Product product, @RequestPart MultipartFile imageFile)
    {
        try
        {
            Product productTemp=service.addProduct(product,imageFile);
            return new ResponseEntity<>(productTemp,HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }

    @GetMapping("product/{prodId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int prodId)
    {
        Product productTemp=service.getProductById(prodId);
        byte[] imageDataObj=productTemp.getImageData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(productTemp.getImageType()))
                .body(imageDataObj);
    }
}
