/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.service;

import com.mycompany.spring_mvc_product.entities.CategoryEntity;
import com.mycompany.spring_mvc_product.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<CategoryEntity> getCategorys(){
        List<CategoryEntity> categorys=(List<CategoryEntity>) categoryRepository.findAll();
        return categorys;
    }
}
