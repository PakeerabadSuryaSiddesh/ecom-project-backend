package com.suryasiddesh.ecom_project_backend.repository;

import com.suryasiddesh.ecom_project_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
