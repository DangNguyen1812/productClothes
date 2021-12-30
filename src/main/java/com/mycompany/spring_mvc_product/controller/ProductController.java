/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.controller;

import com.mycompany.spring_mvc_product.entities.ColorEntity;
import com.mycompany.spring_mvc_product.entities.ImageEntity;
import com.mycompany.spring_mvc_product.entities.ProductDetailEntity;
import com.mycompany.spring_mvc_product.entities.ProductEntity;
import com.mycompany.spring_mvc_product.entities.SizeEntity;

import com.mycompany.spring_mvc_product.service.CategoryService;
import com.mycompany.spring_mvc_product.service.ColorService;
import com.mycompany.spring_mvc_product.service.ImageService;
import com.mycompany.spring_mvc_product.service.ProductDetailService;
import com.mycompany.spring_mvc_product.service.ProductService;
import com.mycompany.spring_mvc_product.service.SizeService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
@Controller
public class ProductController {

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

    @RequestMapping(value = {"/home", "/", "/products"})
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("images", imageService.getAllImages());

//        model.addAttribute("action", "add");
        return "products";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Model model) {
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("date", currentDate);
        model.addAttribute("product", new ProductEntity());
        model.addAttribute("categorys", categoryService.getCategorys());

        model.addAttribute("action", "add");

        return "add-update";
    }

    @RequestMapping("/update/{id}")
    public String updateProduct(Model model, @PathVariable("id") int id) {

        model.addAttribute("categorys", categoryService.getCategorys());
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("action", "update");
        return "add-update";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(Model model, @ModelAttribute("product") ProductEntity product,
            @ModelAttribute(name = "files") MultipartFile[] files, @ModelAttribute("action") String action) {

        try {
            productService.saveProduct(product);

            for (MultipartFile file : files) {

                byte[] bytes = file.getBytes();
                String pathName = "C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\"
                        + "Spring_MVC_Product\\src\\main\\webapp\\resources\\images";
                File dir = new File(pathName);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                if (!file.getOriginalFilename().isEmpty()) {
                    String fileSource = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();
                    File serverFile = new File(fileSource);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();

                    ImageEntity image = new ImageEntity();
                    image.setName(file.getOriginalFilename());
                    image.setProductEntity(product);
                    imageService.saveImage(image);
                }

            }
            if (action.equals("update")) {
                
                return "redirect:/home";
            } else if (action.equals("add")) {
                model.addAttribute("productDetail", new ProductDetailEntity());
                model.addAttribute("product", product);
                model.addAttribute("color", colorService.getColor());
                model.addAttribute("size", sizeService.getSize());
                model.addAttribute("message1", "there no product details");
                return "addDetail";
            }
            return "home";
            
        } catch (Exception e) {
            System.out.println(e);
            return "Error when uploading file" + e;
        }

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchByName(Model model, @ModelAttribute("strSearch") String strSearch) {
        List<ProductEntity> list = productService.searchByName(strSearch);
        model.addAttribute("products", list);
        model.addAttribute("images", imageService.getAllImages());
        return "products";
    }

}
