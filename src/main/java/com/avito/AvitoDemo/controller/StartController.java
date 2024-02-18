package com.avito.AvitoDemo.controller;

import com.avito.AvitoDemo.module.Product;
import com.avito.AvitoDemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class StartController {
    private final ProductService productService;


    @GetMapping("/")
    public String product(@RequestParam(name="title",required = false) String title, Model model){
        model.addAttribute("products",productService.list(title));
        return "product";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3,
                                Product product) throws IOException {
        productService.saveProducts(product,file1,file2,file3);
        return "redirect:/";
    }

    @PostMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProducts(id);
        return "redirect:/";
    }

}
