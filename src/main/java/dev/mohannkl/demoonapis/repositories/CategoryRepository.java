package dev.mohannkl.demoonapis.repositories;

import dev.mohannkl.demoonapis.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(String title);

    Category save(Category category);

    List<Category> findAll();


}
