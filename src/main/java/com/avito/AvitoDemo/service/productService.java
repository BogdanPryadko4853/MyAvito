package com.avito.AvitoDemo.service;

import com.avito.AvitoDemo.module.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class productService {
    private List<Product> products=new ArrayList<>();
    private long ID=0;

    {
        products.add(new Product(++ID,"PlayStation 4","description",65000,"Belgorod","John"));
        products.add(new Product(++ID,"Iphone 11","description",20000,"Belgorod","Tom"));
    }

    public List<Product> list(){ return products;}

    public void saveProducts(Product product){
        product.setId(++ID);
        products.add(product);
    }
    public  void deleteProducts(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for(Product product: products){
            if(product.getId().equals(id)) return product;
        }
        return null;
    }
}
