package com.example.backend.service;

import com.example.backend.dto.PromotionCategoryDto;
import com.example.backend.dto.UpdatePromotionCategoryDto;
import com.example.backend.entity.PromotionCategory;
import com.example.backend.model.PromotionCategorySearchCriteriaModel;
import org.springframework.data.domain.Page;

public interface PromotionCategoryService {
    PromotionCategory getPromotionCategory(Integer id);

    PromotionCategory createPromotionCategory(PromotionCategoryDto promotionCategoryDto) throws Exception;

    PromotionCategory updatePromotionCategory(UpdatePromotionCategoryDto updatePromotionCategoryDto, Integer id) throws Exception;

    Page<PromotionCategory> getPromotionCategories(PromotionCategorySearchCriteriaModel promotionCategorySearchCriteriaModel);
}
