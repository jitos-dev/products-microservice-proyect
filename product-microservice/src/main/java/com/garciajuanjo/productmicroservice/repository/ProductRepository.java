package com.garciajuanjo.productmicroservice.repository;

import com.garciajuanjo.productmicroservice.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface para trabajar con la bbdd de MongoDB
 */
public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}
