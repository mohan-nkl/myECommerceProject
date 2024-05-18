package dev.mohannkl.demoonapis.DTOs;

import dev.mohannkl.demoonapis.models.Category;
import dev.mohannkl.demoonapis.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setPrice(price);
        Category productCategory = new Category();
        productCategory.setTitle(category);
        product.setCategory(productCategory);
        return product;
    }


}
