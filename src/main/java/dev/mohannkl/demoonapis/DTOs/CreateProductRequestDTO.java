package dev.mohannkl.demoonapis.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;
}
