/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.entities;

import com.mycompany.spring_mvc_product.enumeration.Enum.Size;
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
@Table(name = "size")
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column()
    @Enumerated(EnumType.STRING)
    private Size size;
    
    @OneToMany(mappedBy = "sizeEntity",fetch = FetchType.LAZY)
    private List<ProductDetailEntity> productDetailEntity;

    public SizeEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public List<ProductDetailEntity> getProductDetailEntity() {
        return productDetailEntity;
    }

    public void setProductDetailEntity(List<ProductDetailEntity> productDetailEntity) {
        this.productDetailEntity = productDetailEntity;
    }

   
    
    
}
