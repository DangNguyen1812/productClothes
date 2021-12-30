/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.entities;

import com.mycompany.spring_mvc_product.enumeration.Enum.Color;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "color")
public class ColorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column()
    @Enumerated(EnumType.STRING)
    private Color color;
    
    @OneToMany(mappedBy = "colorEntity",fetch = FetchType.LAZY)
    private List<ProductDetailEntity> productDetailEntity;

    public ColorEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<ProductDetailEntity> getProductDetailEntity() {
        return productDetailEntity;
    }

    public void setProductDetailEntity(List<ProductDetailEntity> productDetailEntity) {
        this.productDetailEntity = productDetailEntity;
    }
    
    
}
