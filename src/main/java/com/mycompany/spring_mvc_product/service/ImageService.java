/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.service;

import com.mycompany.spring_mvc_product.entities.ImageEntity;
import com.mycompany.spring_mvc_product.entities.ProductEntity;
import com.mycompany.spring_mvc_product.repository.ImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    
    public void saveImage(ImageEntity image){
        imageRepository.save(image);
    }
    public List<ImageEntity> getImageOfProduct(ProductEntity product){
        List<ImageEntity> listImage=(List<ImageEntity>) imageRepository.findByProductEntity(product);
        return listImage;
    }
    public List<ImageEntity> getAllImages(){
        List<ImageEntity> listImage=(List<ImageEntity>) imageRepository.findAll();
        return listImage;
    }
}
