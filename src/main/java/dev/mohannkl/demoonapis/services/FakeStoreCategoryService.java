package dev.mohannkl.demoonapis.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreCategoryService")
public class FakeStoreCategoryService implements CategoryService {
    private RestTemplate restTemplate;
    public FakeStoreCategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getAllCategories() {
        List<String> categories = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                List.class);

        return categories;
    }
}
