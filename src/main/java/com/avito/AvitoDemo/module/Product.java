package com.avito.AvitoDemo.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="Avito")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="description",columnDefinition = "text")
    private String description;
    @Column(name="price")
    private int price;
    @Column(name="city")
    private String city;
    @Column(name="author")
    private String author;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    @Column(name = "previewImageId")
    private Long previewImageId;
    private LocalDateTime dateTimeOfCreated;

    @PrePersist
    private void init(){
        dateTimeOfCreated = LocalDateTime.now();
    }

    public void addImageToProduct(Image image){
        image.setProduct(this);
        images.add(image);
    }

}
