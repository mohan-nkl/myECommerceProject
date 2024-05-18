package dev.mohannkl.demoonapis.services;

import dev.mohannkl.demoonapis.models.Category;
import dev.mohannkl.demoonapis.repositories.CategoryRepository;
import dev.mohannkl.demoonapis.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ownDatabaseCategoryService")

public class OwnDatabaseCategoryService implements CategoryService {
    CategoryRepository categoryRepository;
    public OwnDatabaseCategoryService(CategoryRepository cateRepo) {
        this.categoryRepository = cateRepo;
    }

    @Override
    public List<String> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<String> titles = new ArrayList<>();
        for (Category category: categories) {
            titles.add(category.getTitle());
        }
        return titles;
    }
}
