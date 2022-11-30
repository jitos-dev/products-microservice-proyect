package com.garciajuanjo.productmicroservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "product")
@Data @NoArgsConstructor
public class ProductEntity {

    @Id
    private String id;
    private String productName;
    private String productDescription;
    private double unitPrice;
}
