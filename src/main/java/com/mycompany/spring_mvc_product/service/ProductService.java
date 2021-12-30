/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.service;

import com.mycompany.spring_mvc_product.entities.ProductEntity;
import com.mycompany.spring_mvc_product.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<ProductEntity> getProducts(){
        List<ProductEntity> products=(List<ProductEntity>) productRepository.getProducts();
        return products;
    }
    public void saveProduct(ProductEntity product){
        productRepository.save(product);
    }
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
    public ProductEntity getProductById(int id){
        Optional<ProductEntity> optional=productRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return new ProductEntity();
    }
    
    public List<ProductEntity> searchByName(String name){
        List<ProductEntity> listSearch = productRepository.findByNameContaining(name);
        return listSearch;
    }
}
