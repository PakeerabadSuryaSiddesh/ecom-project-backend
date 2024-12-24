package com.suryasiddesh.ecom_project_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private Date releaseDate;
    private boolean productAvailable;
    private int StockQuantity;

    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;

}
