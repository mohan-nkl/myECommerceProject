package dev.mohannkl.demoonapis.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long productId;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
