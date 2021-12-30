/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name="product")
public class ProductEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length=50)
    private String name;
    
    @Column(length = 1000)
    private String description;
    
    @Column()
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private CategoryEntity categoryEntity;
    
    @OneToMany(mappedBy = "productEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ImageEntity> imageEntity;
    
    @OneToMany(mappedBy = "productEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ProductDetailEntity> productDetailEntity;

    public ProductEntity() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public List<ImageEntity> getImageEntity() {
        return imageEntity;
    }

    public void setImageEntity(List<ImageEntity> imageEntity) {
        this.imageEntity = imageEntity;
    }

    public List<ProductDetailEntity> getProductDetailEntity() {
        return productDetailEntity;
    }

    public void setProductDetailEntity(List<ProductDetailEntity> productDetailEntity) {
        this.productDetailEntity = productDetailEntity;
    }




    
    
}
