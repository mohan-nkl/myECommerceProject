package dev.mohannkl.demoonapis.controllers;

import dev.mohannkl.demoonapis.services.CategoryService;
import dev.mohannkl.demoonapis.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(@Qualifier("ownDatabaseCategoryService")
                              CategoryService cateServ) {
        this.categoryService = cateServ;
    }

    @GetMapping("/categories")
    public List<String> getAllCategories() {

        return categoryService.getAllCategories();
    }


}
