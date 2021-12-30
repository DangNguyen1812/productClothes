/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.service;

import com.mycompany.spring_mvc_product.entities.ColorEntity;
import com.mycompany.spring_mvc_product.entities.SizeEntity;
import com.mycompany.spring_mvc_product.repository.ColorRepository;
import com.mycompany.spring_mvc_product.repository.ProductDetailRepository;
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
public class ColorService {
    @Autowired
    private ColorRepository colorRepository;
    
    @Autowired
    private ProductDetailRepository productDetailRepository;
    
    public List<ColorEntity> getColor(){
        List<ColorEntity> color= (List<ColorEntity>) colorRepository.findAll();
        return color;
    }
    public ColorEntity getColorById(int id) {
        Optional<ColorEntity> colorEntity=colorRepository.findById(id);
        if(colorEntity.isPresent()){
            return colorEntity.get();
        }
        return new ColorEntity();
    }
    
    public List<ColorEntity> getColorByProductId(int id) {
        List<Integer> color_id = productDetailRepository.findColorByProductIdAndProductDetail(id);
        List<ColorEntity> color = new ArrayList<>();
        for (Integer colorId:color_id) {
            ColorEntity colorEntity = new ColorEntity();
            colorEntity = getColorById(colorId);
            color.add(colorEntity);
        }
        return color;
    }
    
    public List<ColorEntity> getColorBySizeInProductDetail(int productId, int sizeId) {
        List<Integer> color_id = productDetailRepository.findColorBySizeInProductDetail(productId, sizeId);
        List<ColorEntity> color = new ArrayList<>();
        for (Integer colorId:color_id) {
            ColorEntity colorEntity = new ColorEntity();
            colorEntity = getColorById(colorId);
            color.add(colorEntity);
        }
        return color;
    }
}
