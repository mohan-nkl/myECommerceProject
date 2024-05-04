package dev.mohannkl.demoonapis.services;

import dev.mohannkl.demoonapis.models.Category;
import dev.mohannkl.demoonapis.models.Product;

import java.util.List;

public class OwnDatabaseProductService implements ProductService {
    @Override
    public Product getProductDetails(long productId) {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String category, String image, double price) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

}
