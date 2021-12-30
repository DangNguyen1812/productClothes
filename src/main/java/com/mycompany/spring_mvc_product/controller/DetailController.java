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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author ADMIN
 */
@SessionAttributes("sessionDetail")
@Controller
public class DetailController {

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

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String detail(Model model, @ModelAttribute("productDetail") ProductDetailEntity productDetailEntity,
            @RequestParam("action") String action, @ModelAttribute("sessionDetail") List<ProductDetailEntity> listDetail) {

        ProductEntity product = productService.getProductById(productDetailEntity.getProductEntity().getId());

        String message = null;
        for (ProductDetailEntity p : listDetail) {
            if (p.getSizeEntity().getId() == productDetailEntity.getSizeEntity().getId()
                    && p.getColorEntity().getId() == productDetailEntity.getColorEntity().getId()) {
                message = "This color and size already exists";
                break;
            }
        }
        if (message != null) {
            model.addAttribute("message", message);
            model.addAttribute("product", product);
            model.addAttribute("productDetail", new ProductDetailEntity());
            model.addAttribute("color", colorService.getColor());
            model.addAttribute("size", sizeService.getSize());
            model.addAttribute("sessionDetail", listDetail);
            return "addDetail";
        } else {

            SizeEntity size = sizeService.getSizeById(productDetailEntity.getSizeEntity().getId());
            ColorEntity color = colorService.getColorById(productDetailEntity.getColorEntity().getId());

            productDetailEntity.setProductEntity(product);
            productDetailEntity.setSizeEntity(size);
            productDetailEntity.setColorEntity(color);
            listDetail.add(productDetailEntity);

            model.addAttribute("product", product);
            model.addAttribute("productDetail", new ProductDetailEntity());
            model.addAttribute("color", colorService.getColor());
            model.addAttribute("size", sizeService.getSize());
//            model.addAttribute("sessionDetail", listDetail);
            return "addDetail";
        }
    }

    @RequestMapping("/saveDetail")
    public String saveDetail(Model model, @ModelAttribute("sessionDetail") List<ProductDetailEntity> listDetail) {
        for (ProductDetailEntity p : listDetail) {
            productDetailService.saveProductDetail(p);
        }
        listDetail.clear();
        model.addAttribute("sessionDetail", listDetail);
        return "redirect:/products";
    }

    @RequestMapping("/removeDetail/{detail_id}/{product_id}")
    public String removeDetail(Model model, @PathVariable("detail_id") int detailId,
            @PathVariable("product_id") int productId, @ModelAttribute("sessionDetail") List<ProductDetailEntity> listDetail) {

        listDetail.remove(listDetail.get(detailId));
        ProductEntity product = productService.getProductById(productId);

        model.addAttribute("product", product);
        model.addAttribute("productDetail", new ProductDetailEntity());
        model.addAttribute("color", colorService.getColor());
        model.addAttribute("size", sizeService.getSize());
        model.addAttribute("sessionDetail", listDetail);
        return "addDetail";
    }

    @RequestMapping("/showDetail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id, HttpSession session) {
        List<ProductDetailEntity> details = productDetailService.getProductDetailByProductId(id);
        ProductEntity product = productService.getProductById(id);
        List<SizeEntity> size = sizeService.getSizeByProductId(id);
        List<ColorEntity> color = colorService.getColorByProductId(id);
        double price = details.get(0).getPrice();

        model.addAttribute("details", details);
        model.addAttribute("product", product);
        model.addAttribute("sizes", size);
        model.addAttribute("colors", color);
        model.addAttribute("price", price);
        model.addAttribute("productDetail", new ProductDetailEntity());
        model.addAttribute("images", imageService.getImageOfProduct(product));
        return "details";
    }

    



    @ModelAttribute("sessionDetail")
    public List<ProductDetailEntity> listDetailBefore() {
        List<ProductDetailEntity> list = new ArrayList<>();
        return list;
    }
}
