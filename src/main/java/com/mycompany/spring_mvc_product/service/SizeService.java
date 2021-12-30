/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.service;

import com.mycompany.spring_mvc_product.entities.SizeEntity;
import com.mycompany.spring_mvc_product.repository.ProductDetailRepository;
import com.mycompany.spring_mvc_product.repository.SizeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;
    
    @Autowired
    private ProductDetailRepository productDetailRepository;
    
    public List<SizeEntity> getSize(){
        List<SizeEntity> size=(List<SizeEntity>) sizeRepository.findAll();
        return size;
    }
    public SizeEntity getSizeById(int id) {
        Optional<SizeEntity> sizeEntity=sizeRepository.findById(id);
        if(sizeEntity.isPresent()){
            return sizeEntity.get();
        }
        return new SizeEntity();
    }
    public List<SizeEntity> getSizeByProductId(int id) {
        List<Integer> size_id = productDetailRepository.findSizeByProductIdAndProductDetail(id);
        List<SizeEntity> size = new ArrayList<>();
        for (Integer sizeId:size_id) {
            SizeEntity sizeEntity = new SizeEntity();
            sizeEntity = getSizeById(sizeId);
            size.add(sizeEntity);
        }
        return size;
    }
    
    public List<SizeEntity> getSizeByColorInProductDetail(int productId, int colorId) {
        List<Integer> size_id = productDetailRepository.findSizeByColorInProductDetail(productId, colorId);
        List<SizeEntity> size = new ArrayList<>();
        for (Integer sizeId:size_id) {
            SizeEntity sizeEntity = new SizeEntity();
            sizeEntity = getSizeById(sizeId);
            size.add(sizeEntity);
        }
        return size;
    }
}
