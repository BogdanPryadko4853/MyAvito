package com.avito.AvitoDemo.controller;

import com.avito.AvitoDemo.module.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.avito.AvitoDemo.service.*;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class startView {
    private final productService productService;

    @GetMapping("/")
    public String product(Model model){
        model.addAttribute("products",productService.list());
        return "product";
    }

    @GetMapping("product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "product-info";
    }


    @PostMapping("/product/create")
    public String createProduct(Product product){
        productService.saveProducts(product);
        return "redirect:/";
    }

    @PostMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProducts(id);
        return "redirect:/";
    }

}
