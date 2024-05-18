package dev.mohannkl.demoonapis.repositories;

import dev.mohannkl.demoonapis.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    Product findById(long productId);

    List<Product> findAll();

    void deleteById(long productId);

    @Query("select p from Product p where p.category.title = :categoryTitle")
    List<Product> findAllByCategory(@Param("categoryTitle") String categoryTitle);
//    List<Product> findAllByCategory_Title(String categoryTitle);

}
