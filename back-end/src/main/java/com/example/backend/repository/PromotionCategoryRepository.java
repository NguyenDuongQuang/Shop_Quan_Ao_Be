package com.example.backend.repository;
import com.example.backend.entity.PromotionCategory;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionCategoryRepository extends JpaRepository<PromotionCategory, Integer> {
    List<PromotionCategory> findByNameLikeIgnoreCase(String name);

    List<PromotionCategory> findByStatusAndCategory_Id(@NonNull boolean status, @NonNull Integer id);

}