package com.example.backend.repository;
import com.example.backend.entity.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_Id(Integer id);

    List<Product> findByNameLikeIgnoreCase(@NonNull String name);

    @Query("select p from Product p where upper(p.name) like upper(concat('%', ?1, '%'))")
    List<Product> findByNameContainingIgnoreCase(@NonNull String keyword);

    long countByStatus(@NonNull int status);

}