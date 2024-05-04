package dev.mohannkl.demoonapis;

import dev.mohannkl.demoonapis.controllers.ProductController;
import dev.mohannkl.demoonapis.models.Product;
import dev.mohannkl.demoonapis.services.FakeStoreProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoOnApIsApplication {

    public static void main(String[] args) {

//        ProductController pc = new ProductController(new FakeStoreProductService());


        SpringApplication.run(DemoOnApIsApplication.class, args);
    }

}
