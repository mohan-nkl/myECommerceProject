package dev.mohannkl.demoonapis.services;

import dev.mohannkl.demoonapis.models.Category;
import dev.mohannkl.demoonapis.models.Product;
import dev.mohannkl.demoonapis.repositories.CategoryRepository;
import dev.mohannkl.demoonapis.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
@Service("ownDatabaseProductService")
public class OwnDatabaseProductService implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public OwnDatabaseProductService(ProductRepository prodRepo, CategoryRepository cateRepo) {
        this.productRepository = prodRepo;
        this.categoryRepository = cateRepo;
    }
    @Override
    public Product getProductDetails(long productId) {

        return productRepository.findById(productId);
    }

    @Override
    public Product createProduct(String title, String description, String category, String image, double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setPrice(price);

        Category category1 = categoryRepository.findByTitle(category);

        if (category1 == null) {
            category1 = new Category();
            category1.setTitle(category);
//            categoryRepository.save(category1);
        }

        product.setCategory(category1);
        productRepository.save(product);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }


    @Override
    public List<Product> getProductsInASpecificCategory(String title) {

//        return productRepository.findAllByCategory_Title(title);
        return productRepository.findAllByCategory(title);
    }

    public Product updateProduct(Product product, long productId) {
        Product product1 = productRepository.findById(productId);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setLastUpdatedAt(LocalDateTime.now());
        return productRepository.save(product1);
    }

    public void deleteProduct(long productId) {
        productRepository.deleteById(productId);
    }
}
