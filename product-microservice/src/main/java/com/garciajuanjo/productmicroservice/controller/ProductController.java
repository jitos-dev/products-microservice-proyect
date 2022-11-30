package com.garciajuanjo.productmicroservice.controller;

import com.garciajuanjo.productmicroservice.entity.ProductEntity;
import com.garciajuanjo.productmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    @Qualifier("productRepository")
    private ProductRepository productRepository;


    /**
     * Llama a productsRepository y devuelve una lista con todos los productos. @ResponseStatus es muy
     * importante porque nos ahorra bastante código, ya que dice que espera una respuesta de http de
     * estado ok que es valor 200. La forma de hacerlo sin esta anotación es la forma larga de abajo
     * @return List de ProductEntity que hay en la bbdd
     */
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    /*Forma larga sin la anotación @ResponseStatus*/
    public ResponseEntity<List<ProductEntity>> getAllProductsLargo(){
        List<ProductEntity> productEntities = productRepository.findAll();
        return new ResponseEntity<>(productEntities, HttpStatus.OK);
    }

    /**
     * Este método guarda un producto en la bbdd a través de la interface ProductRepository
     * @param productEntity ProductEntity que vamos a guardar en la bbdd
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductEntity productEntity) {
        productRepository.save(productEntity);
    }
}
