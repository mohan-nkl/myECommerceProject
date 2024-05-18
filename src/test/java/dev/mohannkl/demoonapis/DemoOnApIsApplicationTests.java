package dev.mohannkl.demoonapis;

import dev.mohannkl.demoonapis.models.Product;
import dev.mohannkl.demoonapis.repositories.CategoryRepository;
import dev.mohannkl.demoonapis.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoOnApIsApplicationTests {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries() {
//        productRepository.findAll();
//        categoryRepository.findAll();
//        productRepository.findAllByCategory_Title("Cameras");
        categoryRepository.findByTitle("mobiles");
    }
}
