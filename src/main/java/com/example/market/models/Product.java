package com.example.market.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private double price;

    @JsonBackReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Purchase> purchases;
}
