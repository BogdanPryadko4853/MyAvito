package com.avito.AvitoDemo.Repositories;

import com.avito.AvitoDemo.module.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
        List<Product> findByTitle(String title);
}
