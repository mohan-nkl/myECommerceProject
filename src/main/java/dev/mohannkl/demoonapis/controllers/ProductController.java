package dev.mohannkl.demoonapis.controllers;

import dev.mohannkl.demoonapis.DTOs.CreateProductRequestDTO;
import dev.mohannkl.demoonapis.DTOs.ErrorDTO;
import dev.mohannkl.demoonapis.exceptions.ProductNotFoundException;
import dev.mohannkl.demoonapis.models.Category;
import dev.mohannkl.demoonapis.models.Product;
import dev.mohannkl.demoonapis.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;
    public ProductController(@Qualifier("ownDatabaseProductService")
                             ProductService prodServ) {

        this.productService = prodServ;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO request) {
        return productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getImage(),
                request.getPrice()
        );
    }

    @GetMapping("/products/{productId}")
    public Product getProductDetails(@PathVariable("productId") long productId) throws ProductNotFoundException {
        Product product = productService.getProductDetails(productId);
        return product;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/categories/{category}/products")
    public List<Product> getProductsInASpecificCategory(@PathVariable("category")
                                                      String category) {
        return productService.getProductsInASpecificCategory(category);
    }

    @PatchMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") long productId,
                                 @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(product, productId);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") long productId) {

        productService.deleteProduct(productId);
    }
}
