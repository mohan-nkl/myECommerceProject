package dev.mohannkl.demoonapis.services;

import dev.mohannkl.demoonapis.DTOs.FakeStoreProductDTO;
import dev.mohannkl.demoonapis.exceptions.ProductNotFoundException;
import dev.mohannkl.demoonapis.models.Category;
import dev.mohannkl.demoonapis.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductDetails(long productId) throws ProductNotFoundException {
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductResponse =
                restTemplate.getForEntity("https://fakestoreapi.com/products/" +
                productId, FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProduct = fakeStoreProductResponse.getBody();
        if (fakeStoreProduct == null) {
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist. Please try with some other productId.");
        }
        return fakeStoreProduct.toProduct();
    }

    @Override
    public Product createProduct(String title, String description, String category, String image, double price) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);

        FakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDTO, FakeStoreProductDTO.class);
        return response.toProduct();

    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS) {
            products.add(fakeStoreProductDTO.toProduct());
        }
        return products;
    }


}
