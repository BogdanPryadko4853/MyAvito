package com.avito.AvitoDemo.controller;

import com.avito.AvitoDemo.module.Product;
import com.avito.AvitoDemo.service.productService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class startView {
    private final productService productService;

    @GetMapping("/")
    public String product(@RequestParam(name="title",required = false) String title, Model model){
        model.addAttribute("products",productService.list(title));
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
