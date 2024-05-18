package dev.mohannkl.demoonapis.services;

import dev.mohannkl.demoonapis.exceptions.ProductNotFoundException;
import dev.mohannkl.demoonapis.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductDetails(long productId) throws ProductNotFoundException;

    public Product createProduct(String title, String description, String category,
                                 String image, double price);

    public List<Product> getAllProducts();


    public List<Product> getProductsInASpecificCategory(String categoryType);

    public Product updateProduct(Product product, long productId);

    public void deleteProduct(long productId);

}
