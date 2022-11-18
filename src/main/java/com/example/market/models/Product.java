package com.example.market.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

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
    private int id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;

    private int price;

    @OneToMany(mappedBy = "product")
    private List<Purchase> purchases;
}
