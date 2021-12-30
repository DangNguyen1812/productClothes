/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.repository;

import com.mycompany.spring_mvc_product.entities.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
    
    @Query(value = "SELECT * FROM jv44_mvc_product.product order by createDate desc,id desc ",nativeQuery = true)
    List<ProductEntity> getProducts();
    
    List<ProductEntity> findByNameContaining(String name);
}
