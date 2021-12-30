/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.controller;

import com.mycompany.spring_mvc_product.entities.ColorEntity;
import com.mycompany.spring_mvc_product.entities.ProductDetailEntity;
import com.mycompany.spring_mvc_product.entities.ProductEntity;
import com.mycompany.spring_mvc_product.entities.SizeEntity;
import com.mycompany.spring_mvc_product.service.CategoryService;
import com.mycompany.spring_mvc_product.service.ColorService;
import com.mycompany.spring_mvc_product.service.ImageService;
import com.mycompany.spring_mvc_product.service.ProductDetailService;
import com.mycompany.spring_mvc_product.service.ProductService;
import com.mycompany.spring_mvc_product.service.SizeService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author ADMIN
 */
@SessionAttributes("cart")
@Controller
public class CartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private ProductDetailService productDetailService;
    
    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public String cardDetail(Model model, HttpSession session,               
            @ModelAttribute("cart") List<ProductDetailEntity> cart) {
       
        return "cart";
    }
    
    
    @RequestMapping(value = {"check-order"}, method = RequestMethod.POST)
    public String checkOrder(Model model, @ModelAttribute("productDetail") ProductDetailEntity productDetail,
            HttpSession session,@ModelAttribute("cart") List<ProductDetailEntity> cart) {
        int productId = productDetail.getProductEntity().getId();
        ProductEntity product = productService.getProductById(productId);

        List<SizeEntity> sizes = sizeService.getSizeByProductId(productId);
        List<ColorEntity> colors = colorService.getColorByProductId(productId);
        if (productDetail.getQuantity() == 0) {

            int sizeId = productDetail.getSizeEntity().getId();
            int colorId = productDetail.getColorEntity().getId();
            double price = 0;
            List<ColorEntity> colorsCheck = colorService.getColorBySizeInProductDetail(productId, sizeId);
            for (ColorEntity color : colorsCheck) {
                if (color.getId() == productDetail.getColorEntity().getId()) {
                    price = productDetailService.getPriceByColorAndSize(colorId, sizeId, productId).getPrice();
                    break;
                } else {
                    price = productDetailService.getPriceByColorAndSize(colorsCheck.get(0).getId(), sizeId, productId).getPrice();
                }
            }

            model.addAttribute("price", price);
            model.addAttribute("sizes", sizes);
            model.addAttribute("colors", colors);
            model.addAttribute("productDetail", productDetail);
            model.addAttribute("product", product);
            model.addAttribute("images", imageService.getImageOfProduct(product));

            return "details";
        } else {
            cart.add(productDetail);
            return "cart";
//            int quantityDB = productDetailService.getPriceByColorAndSize(productDetail.getColorEntity().getId(),
//                    productDetail.getSizeEntity().getId(), productDetail.getProductEntity().getId()).getQuantity();
//            double price = productDetailService.getPriceByColorAndSize(productDetail.getColorEntity().getId(),
//                    productDetail.getSizeEntity().getId(), productDetail.getProductEntity().getId()).getPrice();
//            int quantity = productDetail.getQuantity();
//            if (quantity > quantityDB) {
//                String message = "kho khong du so luong!";
//                model.addAttribute("message", message);
//                model.addAttribute("price", price);
//                model.addAttribute("sizes", sizes);
//                model.addAttribute("colors", colors);
//                model.addAttribute("productDetail", productDetail);
//                model.addAttribute("product", product);
//                model.addAttribute("images", imageService.getImageOfProduct(product));
//                return "details";
//            } else {
//                cart.add(productDetail);
//                return "redirect:/cart";
//            }

            
        }

    }
    
    @ModelAttribute("cart")
    public List<ProductDetailEntity> cartItems() {
        List<ProductDetailEntity> list = new ArrayList<>();
        return list;
    }

}

