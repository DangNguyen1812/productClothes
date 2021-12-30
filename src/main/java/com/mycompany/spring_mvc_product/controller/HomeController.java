/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_product.controller;


import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ADMIN
 */

@Controller
public class HomeController {
    
    @RequestMapping(value = {"/aaa"}, method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        
        
        return "home";
    }

    @RequestMapping("/requestParam")
    public String requestParam(Model model, @RequestParam("name") String name,
            @RequestParam(value = "age") int age,
            @RequestParam(value = "country", required = false,
                    defaultValue = "VN") String country) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("country", country);
        return "result";
    }

    @RequestMapping("/pathVariable/{name}/{age}/{country}")
    public String pathVeriable(Model model,
            @PathVariable("name") String name,
            @PathVariable("age") int age,
            @PathVariable("country") String country) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("country", country);
        return "result";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView otherHomeView() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("infor", "this is model and view");
        mav.setViewName("modelAndView");
        return mav;
    }
    
}
