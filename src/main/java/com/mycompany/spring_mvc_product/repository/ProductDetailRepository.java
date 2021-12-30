/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.repository;

import com.mycompany.spring_mvc_product.entities.ProductDetailEntity;
import com.mycompany.spring_mvc_product.entities.SizeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ADMIN
 */
@Repository
public interface ProductDetailRepository extends CrudRepository<ProductDetailEntity, Integer>{
    
    @Query(value = "SELECT * FROM jv44_mvc_product.product_detail where product_id = ?1",nativeQuery = true)
    List<ProductDetailEntity> findByProductId(int id);
    
    @Query(value = "SELECT distinct size_id FROM jv44_mvc_product.product_detail where product_id =?1" , nativeQuery = true)
    List<Integer> findSizeByProductIdAndProductDetail(int id);
    
    @Query(value = "SELECT distinct color_id FROM jv44_mvc_product.product_detail where product_id =?1" , nativeQuery = true)
    List<Integer> findColorByProductIdAndProductDetail(int id);
    
    @Query(value = "SELECT * FROM jv44_mvc_product.product_detail where color_id = ?1 and size_id = ?2 and product_id = ?3" ,nativeQuery = true)
    ProductDetailEntity findPriceByColorAndSize(int colorId, int sizeId, int productId);
    
    @Query(value = "SELECT color_id FROM jv44_mvc_product.product_detail where product_id = ?1 and size_id = ?2", nativeQuery = true) 
    List<Integer> findColorBySizeInProductDetail(int productId, int sizeId);
    
    @Query(value = "SELECT size_id FROM jv44_mvc_product.product_detail where product_id = ?1 and color_id = ?2", nativeQuery = true) 
    List<Integer> findSizeByColorInProductDetail(int productId, int sizeId);

}
