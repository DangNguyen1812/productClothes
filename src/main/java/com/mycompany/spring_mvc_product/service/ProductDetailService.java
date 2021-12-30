/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.service;

import com.mycompany.spring_mvc_product.entities.ProductDetailEntity;
import com.mycompany.spring_mvc_product.entities.ProductEntity;
import com.mycompany.spring_mvc_product.entities.SizeEntity;
import com.mycompany.spring_mvc_product.repository.ProductDetailRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;
    
    public void saveProductDetail(ProductDetailEntity productDetail){
        productDetailRepository.save(productDetail);
    }
    public List<ProductDetailEntity> getProductDetailByProductId(int id) {
        List<ProductDetailEntity> productDetails = productDetailRepository.findByProductId(id);
        return productDetails;
    }
    
    public ProductDetailEntity getPriceByColorAndSize(int colorId, int sizeId, int productId) {
        ProductDetailEntity productDetailEntity = productDetailRepository.findPriceByColorAndSize(colorId, sizeId, productId);
        return productDetailEntity;
    }

}
