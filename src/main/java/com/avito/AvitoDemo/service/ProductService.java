package com.avito.AvitoDemo.service;

import com.avito.AvitoDemo.repositories.ProductRepository;
import com.avito.AvitoDemo.module.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> list(String title){
        if(title!=null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProducts(Product product){
        log.info("Saving new {}",product);
        productRepository.save(product);
    }
    public  void deleteProducts(Long id){

        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
       return productRepository.findById(id).orElse(null);
    }
}
