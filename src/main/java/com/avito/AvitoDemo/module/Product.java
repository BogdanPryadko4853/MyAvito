package com.avito.AvitoDemo.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "product")
    private ArrayList<image> images=new ArrayList<>();
    private Long previewImageId;
}
